package com.silionie.server.controllers;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.Unit;
import com.silionie.server.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reviews")
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
    ResponseEntity<Optional<Unit>> apply(@RequestBody Review review) {
        Optional<Unit> updatedUnit = reviewService.applyReview(review);
        if(updatedUnit.isPresent()){
            return ResponseEntity.ok(updatedUnit);
        }
        if(updatedUnit == null){
            return ResponseEntity.badRequest().build();
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
