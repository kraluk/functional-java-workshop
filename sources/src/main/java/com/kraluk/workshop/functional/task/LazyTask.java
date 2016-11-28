package com.kraluk.workshop.functional.task;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.function.Supplier;

import javaslang.Function4;
import javaslang.Function5;
import javaslang.Lazy;

/**
 * Proposed solution of the Task 2
 *
 * @author lukasz
 */
@Slf4j
public class LazyTask {

    public static Lazy<Double> calculate(Double x, Double a, Double b, Double c) {
        return Lazy
            .of(() -> someComplexAndHeavyMathOperation(x, a, b, c));
    }

    public static Serializable calculateInAnotherWay(Double x, Double a, Double b, Double c) {
        return Lazy
            .val(() -> someComplexAndHeavyMathOperation(x, a, b, c),
                Serializable.class);
    }

    // ------------------------------------------------------------------------------------------

    public static Serializable calculateInAlternativeWay(Double x, Double a, Double b, Double c) {

        return Lazy
            .val(bind(LazyTask::someComplexAndHeavyMathOperation, x, a, b, c),
                Serializable.class);
    }

    private static <T> Supplier<T> bind(Function4<T, T, T, T, T> fn, T x, T a, T b, T c) {
        return () -> fn.apply(x, a, b, c);
    }

    // ------------------------------------------------------------------------------------------

    public static Double someComplexAndHeavyMathOperation(Double x, Double a, Double b, Double c) {
        return a * Math.pow(x, 2) + b * x + c;
    }

    // ------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Serializable solution2 = calculateInAnotherWay(1.0, 1.0, 1.0, 1.0);

        Lazy<Double> solution = calculate(2.0, 2.0, 2.0, 2.0);

        log.info("Solution_1: '{}'", solution.isEvaluated());
        log.info("Solution_1: '{}'", solution.get());
        log.info("Solution_1: '{}'", solution.isEvaluated());
        log.info("Solution_1: '{}'", solution.get());

        // Casting '(Double) solution2' throws the ClassCastException, because of Proxy usage
        //log.info("Solution_2: '{}'", (Double) solution2);
        log.info("Solution_2: '{}'",
            Double.valueOf(String.valueOf(solution2))); // yep, String.valueOf should be good enough
    }
}
