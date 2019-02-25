package com.silionie.server.controllers;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.User;
import com.silionie.server.jwt.security.JwtUser;
import com.silionie.server.jwt.security.TokenProvider;
import com.silionie.server.jwt.security.service.JwtUserDetailsService;
import com.silionie.server.mapper.ReviewResponse;
import com.silionie.server.mapper.ReviewResponseMapper;
import com.silionie.server.service.ReviewService;
import com.silionie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.silionie.server.jwt.security.Constants.HEADER_STRING;


@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private TokenProvider jwtTokenProvider;

    @Autowired
    private UserService user;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<?> apply(HttpServletRequest request, @RequestBody Review review) {
        String token = request.getHeader(HEADER_STRING).substring(7);
        String username = jwtTokenProvider.getUserNameFromToken(token);
        User user = this.user.findUser(username);
        review.setUserId(user.getId());
        ReviewResponse reviewResponse = reviewService.applyReview(review);
        if(reviewResponse != null && reviewResponse.getUnit() != null){
            return ResponseEntity.ok(reviewResponse);
        }
        return ResponseEntity.status(422).body("Post could not be completed.");
    }

}
