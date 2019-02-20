package com.silionie.server.service;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.Unit;
import com.silionie.server.repository.ReviewRepository;
import com.silionie.server.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UnitRepository unitRepository;

    public Optional<Unit> applyReview(Review review){
        if(review == null) return null;

        List<Review> reviewByUnitAndColonist = reviewRepository.findReviewByUnitAndColonist(review.getUnitId(), review.getColonistId());
        if(reviewByUnitAndColonist.size()>0) return null;

        updateDate(review);
        Review persistedReview = reviewRepository.save(review);
        if(persistedReview != null){
            updateUnitScore(review.getUnitId());
        }
        return unitRepository.findById(review.getUnitId());
    }

    private void updateUnitScore(Long unitId){
        Optional<Unit> persistedUnit = unitRepository.findById(unitId);

        if(persistedUnit.isPresent()){
            try{
                Map<Integer, Long> reviewsByUnitMap = getReviewsByUnit(persistedUnit.get().getId());
                int sumOfProduct = 0;
                int sumTotal = 0;
                int score = 0;

                for(Map.Entry reviewByUnit : reviewsByUnitMap.entrySet()){
                    int a = (int) reviewByUnit.getKey();
                    long b = (long)reviewByUnit.getValue();
                    sumOfProduct += a*b;
                    sumTotal += b;
                }

                if(sumTotal != 0){
                    score = sumOfProduct / sumTotal;
                    persistedUnit.get().setScore(score);
                    unitRepository.save(persistedUnit.get());
                }
            }catch (Exception ex){
                System.err.println("Update score error :" + ex.getMessage());
            }
        }
    }

    private void updateDate(Review review){
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        review.setCreatedDate(out);
    }

    private Map<Integer, Long> getReviewsByUnit(Long unitId){
        Map<Integer, Long> mappedResult = new HashMap<>();
        List<Object[]> queryResult = reviewRepository.countReviewsByUnitAndStar(unitId);
        for (Object[] obj : queryResult ) {
            Integer star = (Integer) obj[0];
            Long numOfStars = (Long) obj[1];
            mappedResult.put(star, numOfStars);
        }
        return mappedResult;
    }
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
