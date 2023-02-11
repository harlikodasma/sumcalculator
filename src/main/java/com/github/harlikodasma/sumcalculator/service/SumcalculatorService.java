package com.github.harlikodasma.sumcalculator.service;

import com.github.harlikodasma.sumcalculator.dto.CalculationDto;
import com.github.harlikodasma.sumcalculator.dto.PastCalculationQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.github.harlikodasma.sumcalculator.validator.SumcalculatorValidator.validateCalculationDto;
import static com.github.harlikodasma.sumcalculator.validator.SumcalculatorValidator.validatePastCalculationQueryDto;
import static java.util.Comparator.comparingInt;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class SumcalculatorService {

    private final List<CalculationDto> pastCalculations;

    public synchronized CalculationDto calculateSum(CalculationDto calculationDto) {
        validateCalculationDto(calculationDto);
        var newCalculation = new CalculationDto(calculationDto.getFirstTerm(),
                calculationDto.getSecondTerm(),
                calculationDto.getFirstTerm() + calculationDto.getSecondTerm());
        pastCalculations.add(newCalculation);
        return newCalculation;
    }

    public synchronized List<CalculationDto> queryPastCalculations(PastCalculationQueryDto pastCalculationQueryDto) {
        validatePastCalculationQueryDto(pastCalculationQueryDto);
        if (isNull(pastCalculationQueryDto.getNumber())) {
            return List.of();
        }

        return pastCalculations.stream()
                .filter(calc -> filterPastCalculations(pastCalculationQueryDto.getNumber(), calc))
                .sorted(getComparatorMethod(pastCalculationQueryDto.getAscending()))
                .toList();
    }

    private boolean filterPastCalculations(Integer number, CalculationDto calculationDto) {
        return number.equals(calculationDto.getFirstTerm())
                || number.equals(calculationDto.getSecondTerm())
                || number.equals(calculationDto.getResult());
    }

    private Comparator<CalculationDto> getComparatorMethod(boolean ascending) {
        return ascending
                ? comparingInt(CalculationDto::getResult)
                : comparingInt(CalculationDto::getResult).reversed();
    }
}
