package com.github.harlikodasma.sumcalculator.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.github.harlikodasma.sumcalculator.constants.SumcalculatorErrorConstants.ERROR_SUM_TERM_MAX_VALUE;
import static com.github.harlikodasma.sumcalculator.constants.SumcalculatorErrorConstants.ERROR_SUM_TERM_MIN_VALUE;
import static com.github.harlikodasma.sumcalculator.constants.SumcalculatorErrorConstants.ERROR_SUM_TERM_MISSING;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CalculationDto {

    @NotNull(message = ERROR_SUM_TERM_MISSING)
    @Min(value = 0, message = ERROR_SUM_TERM_MIN_VALUE)
    @Max(value = 100, message = ERROR_SUM_TERM_MAX_VALUE)
    private Integer firstTerm;

    @NotNull(message = ERROR_SUM_TERM_MISSING)
    @Min(value = 0, message = ERROR_SUM_TERM_MIN_VALUE)
    @Max(value = 100, message = ERROR_SUM_TERM_MAX_VALUE)
    private Integer secondTerm;

    private Integer result;
}
