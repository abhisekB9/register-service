package com.online.travel.register.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.online.travel.register.entity.Hotel;
import com.online.travel.register.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

//    @Autowired
//    private Producer producer;

    public Hotel saveHotel(Hotel hotel) throws JsonProcessingException {
        Hotel savedHotel = hotelRepository.save(hotel);
        //String message = producer.sendMessage(savedHotel);
        //log.info("Message : {}", message);
        return savedHotel;
    }
}
