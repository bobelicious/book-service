package com.bobelicious.bookservice.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cambio implements Serializable {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String environment;
}
