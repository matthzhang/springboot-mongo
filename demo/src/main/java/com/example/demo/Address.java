package com.example.demo;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String postCode;
}
