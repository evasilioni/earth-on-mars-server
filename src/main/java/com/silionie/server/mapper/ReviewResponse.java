package com.silionie.server.mapper;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.Unit;

public class ReviewResponse {
    private String responseMessage;
    private Unit unit;
    private Review review;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

}