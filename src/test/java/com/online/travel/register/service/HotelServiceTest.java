package com.online.travel.register.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.online.travel.register.entity.Hotel;
import com.online.travel.register.repository.HotelRepository;
import com.online.travel.register.util.Producer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTest {

    @Mock
    private Producer producer;

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService service;

    @Test
    public void when_user_save_hotel_it_should_return_hotel() throws JsonProcessingException {
        Hotel dto = Hotel.builder().hotelDescription("Desc").hotelName("name").hotelPrice(BigDecimal.valueOf(100)).build();
        Mockito.when(hotelRepository.save(dto)).thenReturn(dto);
        Hotel savedDto = service.saveHotel(dto);
        Assert.assertEquals(savedDto.getHotelName(),dto.getHotelName());
    }
}
