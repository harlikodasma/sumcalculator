package com.github.harlikodasma.sumcalculator.validator;

import com.github.harlikodasma.sumcalculator.dto.CalculationDto;
import com.github.harlikodasma.sumcalculator.dto.PastCalculationQueryDto;
import com.github.harlikodasma.sumcalculator.exceptions.SumcalculatorServiceRestClientException;
import jakarta.validation.Validator;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@NoArgsConstructor(access = PRIVATE)
public class SumcalculatorValidator {

    private static final Validator validator;

    static {
        try (var validatorFactory = buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }
    }

    public static void validateCalculationDto(CalculationDto calculationDto) {
        var errors = new ArrayList<>(validator.validate(calculationDto));
        if (isNotEmpty(errors)) {
            throw new SumcalculatorServiceRestClientException(errors.get(0).getMessage());
        }
    }

    public static void validatePastCalculationQueryDto(PastCalculationQueryDto pastCalculationQueryDto) {
        var errors = new ArrayList<>(validator.validate(pastCalculationQueryDto));
        if (isNotEmpty(errors)) {
            throw new SumcalculatorServiceRestClientException(errors.get(0).getMessage());
        }
    }
}
