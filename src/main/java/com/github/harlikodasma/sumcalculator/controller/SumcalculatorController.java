package com.github.harlikodasma.sumcalculator.controller;

import com.github.harlikodasma.sumcalculator.dto.CalculationDto;
import com.github.harlikodasma.sumcalculator.dto.PastCalculationQueryDto;
import com.github.harlikodasma.sumcalculator.service.SumcalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sum")
@RequiredArgsConstructor
public class SumcalculatorController {

    private final SumcalculatorService sumcalculatorService;

    @GetMapping("calculate")
    public CalculationDto calculateSum(CalculationDto calculationDto) {
        return sumcalculatorService.calculateSum(calculationDto);
    }

    @GetMapping("query")
    public List<CalculationDto> queryPastCalculations(PastCalculationQueryDto pastCalculationQueryDto) {
        return sumcalculatorService.queryPastCalculations(pastCalculationQueryDto);
    }
}
