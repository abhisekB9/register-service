package com.online.travel.register.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hotelName")
    private String hotelName;

    @Column(name = "hotelDescription")
    private String hotelDescription;

    @Column(name = "hotelPrice")
    private BigDecimal hotelPrice;

    // More fields and objects will be added
}
