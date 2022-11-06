package com.bobelicious.bookservice.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 180, nullable = false)
    private String author;
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    @Column(nullable =false)
    private BigDecimal price;
    @Column(nullable = false, length = 250)
    private String title;
    @Transient
    private String currency;
    @Transient
    private String environment; 
}
