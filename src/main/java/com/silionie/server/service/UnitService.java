package com.silionie.server.service;

import com.silionie.server.domain.Unit;
import com.silionie.server.domain.User;
import com.silionie.server.repository.UnitRepository;
import com.silionie.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> findUnits(String title, String region){
        if(!isEmpty(title) && !isEmpty(region)){
            return unitRepository.findByTitleAndRegionOrderByScoreDesc(title, region);
        } else if(!isEmpty(title)){
            return unitRepository.findByTitleOrderByScoreDesc(title);
        }else if(!isEmpty(region)){
            return unitRepository.findByRegionOrderByScoreDesc(region);
        }
        return unitRepository.findAll();
    }

    private static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
