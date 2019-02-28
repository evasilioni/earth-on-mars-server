package com.silionie.server.controllers;

import com.silionie.server.domain.Unit;
import com.silionie.server.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(
            value = "/units",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<List<Unit>> getUnits(@RequestParam(value = "title", required = false) String title,
                                        @RequestParam(value = "region", required = false) String region,
                                        @RequestParam(value = "page") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Unit> units = unitService.findUnits(pageable);
        if (page > units.getTotalPages()) {
            ResponseEntity.status(404).body("Not found any other units.");
        }
        return ResponseEntity.ok(units.getContent());
    }
}
