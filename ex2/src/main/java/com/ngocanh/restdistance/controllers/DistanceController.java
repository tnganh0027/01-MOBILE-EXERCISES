package com.ngocanh.restdistance.controllers;

import com.ngocanh.restdistance.model.Distance;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DistanceController {
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/distance")
    public Distance getDistance(@RequestParam(required = true) String lat1, @RequestParam(required = true) String lon1,
                                @RequestParam(required = true) String lat2, @RequestParam(required = true) String lon2){

        return new Distance(lat1, lon1, lat2, lon2);

    }
}
