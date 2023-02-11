package com.github.harlikodasma.sumcalculator.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.harlikodasma.sumcalculator.constants.SumcalculatorErrorConstants.ERROR_QUERY_BOOLEAN_MISSING;
import static com.github.harlikodasma.sumcalculator.constants.SumcalculatorErrorConstants.ERROR_QUERY_NUMBER_MAX_VALUE;
import static com.github.harlikodasma.sumcalculator.constants.SumcalculatorErrorConstants.ERROR_QUERY_NUMBER_MIN_VALUE;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PastCalculationQueryDto {

    @Min(value = 0, message = ERROR_QUERY_NUMBER_MIN_VALUE)
    @Max(value = 100, message = ERROR_QUERY_NUMBER_MAX_VALUE)
    private Integer number;

    @NotNull(message = ERROR_QUERY_BOOLEAN_MISSING)
    private Boolean ascending;
}
