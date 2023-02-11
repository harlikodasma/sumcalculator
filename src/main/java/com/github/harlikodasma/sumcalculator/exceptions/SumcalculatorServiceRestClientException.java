package com.github.harlikodasma.sumcalculator.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumcalculatorServiceRestClientException extends RuntimeException {

    public SumcalculatorServiceRestClientException(String message) {
        super(message);
    }
}
