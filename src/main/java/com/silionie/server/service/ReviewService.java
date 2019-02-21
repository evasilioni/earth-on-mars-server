package com.silionie.server.service;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.Unit;
import com.silionie.server.mapper.ReviewResponse;
import com.silionie.server.mapper.ReviewResponseMapper;
import com.silionie.server.repository.ReviewRepository;
import com.silionie.server.repository.UnitRepository;
import com.silionie.server.utilities.UnitCalculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ReviewService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UnitRepository unitRepository;

    public ReviewResponse applyReview(Review review){
        Optional<Unit> persistedUnit = unitRepository.findById(review.getUnitId());
        if(persistedUnit.isPresent()){

            List<Review> reviewByUnitAndColonist = reviewRepository.findReviewByUnitAndUser(review.getUnitId(), review.getUserId());
            if(reviewByUnitAndColonist.size()>0) {
                ReviewResponseMapper.map("User has already applied unitReview for that unit.", persistedUnit.get(), reviewByUnitAndColonist.get(0));
            }

            try {
                updateDate(review);
                Review persistedUnitReview = reviewRepository.save(review);
                if(persistedUnitReview != null){
                    Map<Integer, Long> reviewsByUnitMap = reviewRepository.findReviewsByUnitAndStar(review.getUnitId());
                    int score = UnitCalculations.calculateScore(reviewsByUnitMap);
                    persistedUnit.get().setScore(score);
                    unitRepository.save(persistedUnit.get());

                    return ReviewResponseMapper.map("UnitReview applied.", persistedUnit.get(), persistedUnitReview);
                }
            }catch (Exception ex){
                LOGGER.error(ex.getMessage());
                return ReviewResponseMapper.map("Something went wrong! ", null, null);
            }
        }
        return ReviewResponseMapper.map("No unit to apply review", null,review);
    }
    private void updateDate(Review review){
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        review.setCreatedDate(out);
    }


    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
