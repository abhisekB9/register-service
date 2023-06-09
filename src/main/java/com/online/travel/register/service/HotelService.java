package com.online.travel.register.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.online.travel.register.entity.Hotel;
import com.online.travel.register.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

//    @Autowired
//    private Producer producer;

    public Hotel saveHotel(Hotel hotel) throws JsonProcessingException {
        Hotel savedHotel = hotelRepository.save(hotel);
        //producer.sendMessage(savedHotel);
        return savedHotel;
    }
}
