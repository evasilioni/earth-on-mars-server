package com.silionie.server.repository;

import com.silionie.server.domain.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByTitleAndRegionOrderByScoreDesc(String title, String region);

    List<Unit> findByTitleOrderByScoreDesc(String title);

    List<Unit> findByRegionOrderByScoreDesc(String region);

    Page<Unit> findAll(Pageable pageable);
}
