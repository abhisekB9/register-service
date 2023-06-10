package com.online.travel.register.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.travel.register.entity.Hotel;
import com.online.travel.register.service.HotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelController.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private HotelService service;

    @Test
    public void createHotel() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .post("/hotel/save")
                        .content(asJsonString(Hotel.builder().hotelDescription("desc")
                                .hotelName("name").hotelPrice(BigDecimal.valueOf(100)).build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}