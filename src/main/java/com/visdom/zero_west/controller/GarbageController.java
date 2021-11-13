package com.visdom.zero_west.controller;

import com.visdom.zero_west.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/garbage")
public class GarbageController {
    GarbageService garbageService;

    @Autowired
    public GarbageController(GarbageService garbageService) {
        this.garbageService = garbageService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllGarbage() {
        try {
            return new ResponseEntity<>(garbageService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
