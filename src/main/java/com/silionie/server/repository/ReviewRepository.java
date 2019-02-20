package com.silionie.server.repository;

import com.silionie.server.domain.Review;
import com.silionie.server.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select numberOfStar, count(*) as reviewNum from Review r where r.unitId = :unitId group by r.numberOfStar,r.unitId")
    List<Object[]> countReviewsByUnitAndStar(@Param("unitId") Long unitId);

    @Query("select r from Review r where r.unitId = :unitId and r.colonistId = :colonistId")
    List<Review> findReviewByUnitAndColonist(@Param("unitId") Long unitId, @Param("colonistId") String colonistId);
}
