package com.kraluk.workshop.functional.slang;

import javaslang.control.Try;

/**
 * JavaSlang's Try Examples
 *
 * @author lukasz
 */
public class TryExamples {

    public static Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }
}