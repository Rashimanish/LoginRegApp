package com.example.loginreg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestDTO {
    private String id;
    private String testCode;
    private String testName;
    private double price;
    
}
