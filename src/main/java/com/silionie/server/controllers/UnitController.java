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
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(
            value = "/units",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<?> getUnits(@RequestParam(value = "title", required = false) String title,
                                        @RequestParam(value = "region", required = false) String region) {
        List<Unit> units = unitService.findUnits(title, region);
        if(units.size()>0){
            return ResponseEntity.ok(units);
        }
        return ResponseEntity.status(404).body("Empty units.");
    }
}
