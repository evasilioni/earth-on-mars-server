package com.silionie.server.mapper;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.Unit;

public class ReviewResponseMapper {
    public static ReviewResponse map(String responseMessage, Unit unit, Review review){
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setResponseMessage(responseMessage);
        reviewResponse.setReview(review);
        reviewResponse.setUnit(unit);
        return reviewResponse;
    }
}

