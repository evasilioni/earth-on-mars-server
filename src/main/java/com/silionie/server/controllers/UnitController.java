package com.silionie.server.controllers;

import com.silionie.server.domain.Unit;
import com.silionie.server.domain.User;
import com.silionie.server.service.UnitService;
import com.silionie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<List<Unit>> getUnits(@Param("title") String title, @Param("region") String region) {
        List<Unit> units = unitService.findUnits(title, region);
        if(units.size()>0){
            return ResponseEntity.ok(units);
        }
        return ResponseEntity.notFound().build();
    }
}
