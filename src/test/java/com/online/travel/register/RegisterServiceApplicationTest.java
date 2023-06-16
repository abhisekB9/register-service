package com.online.travel.register;

import com.online.travel.register.entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RegisterServiceApplicationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testSaveHotel() throws Exception {
		Hotel dto = Hotel.builder().hotelDescription("Desc").hotelName("name").hotelPrice(BigDecimal.valueOf(100)).build();

		ResponseEntity<Hotel> response = restTemplate.postForEntity(createURLWithPort("/hotel/save"), dto, Hotel.class);

		Hotel actual = response.getBody();

		assertTrue(actual.getHotelName().equals(dto.getHotelName()));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
