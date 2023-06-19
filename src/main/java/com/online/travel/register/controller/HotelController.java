package com.online.travel.register.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.online.travel.register.entity.Hotel;
import com.online.travel.register.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel/register")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping("/save")
    public Hotel saveHotel(@RequestBody Hotel hotel) throws JsonProcessingException {
        return service.saveHotel(hotel);
    }

    @GetMapping("/health")
    public String health(){
        return "Success";
    }
}
