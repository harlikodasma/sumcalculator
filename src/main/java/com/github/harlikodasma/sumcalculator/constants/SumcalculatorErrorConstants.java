package com.github.harlikodasma.sumcalculator.constants;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class SumcalculatorErrorConstants {

    public static final String ERROR_SUM_TERM_MAX_VALUE = "Sum terms cannot be higher than 100.";
    public static final String ERROR_SUM_TERM_MIN_VALUE = "Sum terms cannot be lower than 0.";
    public static final String ERROR_SUM_TERM_MISSING = "Sum terms must be present.";
    public static final String ERROR_QUERY_BOOLEAN_MISSING = "Query order must be provided.";
    public static final String ERROR_QUERY_NUMBER_MAX_VALUE = "Number cannot be higher than 100.";
    public static final String ERROR_QUERY_NUMBER_MIN_VALUE = "Number cannot be lower than 0.";
}
