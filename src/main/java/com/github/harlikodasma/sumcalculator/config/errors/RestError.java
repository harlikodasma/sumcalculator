package com.github.harlikodasma.sumcalculator.config.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestError {

    private int status;
    private String message;
}
