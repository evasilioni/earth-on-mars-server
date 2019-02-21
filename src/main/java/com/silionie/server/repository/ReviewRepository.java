package com.silionie.server.repository;

import com.silionie.server.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select numberOfStar, count(*) as reviewNum from Review r where r.unitId = :unitId group by r.numberOfStar,r.unitId")
    List<Object[]> countReviewsByUnitAndStar(@Param("unitId") Long unitId);

    @Query("select r from Review r where r.unitId = :unitId and r.userId = :userId")
    List<Review> findReviewByUnitAndUser(@Param("unitId") Long unitId, @Param("userId") Long userId);

    default Map<Integer, Long> findReviewsByUnitAndStar(Long unitId) {
        List<Object[]> queryResult = countReviewsByUnitAndStar(unitId);
        Map<Integer, Long> mappedResult = new HashMap<>();
        for (Object[] obj : queryResult ) {
            Integer star = (Integer) obj[0];
            Long numOfStars = (Long) obj[1];
            mappedResult.put(star, numOfStars);
        }
        return mappedResult;
    }
}
