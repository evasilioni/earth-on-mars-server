package com.silionie.server.controllers;

import com.silionie.server.domain.Review;
import com.silionie.server.mapper.ReviewResponse;
import com.silionie.server.mapper.ReviewResponseMapper;
import com.silionie.server.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(
            value = "/apply",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<ReviewResponse> apply(@RequestBody Review review) {
        if(review == null) return ResponseEntity.badRequest().build();

        ReviewResponse reviewResponse = reviewService.applyReview(review);
        if(reviewResponse != null && reviewResponse.getUnit() != null){
            return ResponseEntity.ok(reviewResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<List<Review>> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        if(reviews.size() > 0){
            return ResponseEntity.ok(reviews);
        }
        return ResponseEntity.notFound().build();
    }
}
