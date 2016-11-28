package com.kraluk.workshop.functional.example;

import lombok.extern.slf4j.Slf4j;

import javaslang.Lazy;

/**
 * Lazy Examples
 *
 * @author lukasz
 */
@Slf4j
public class LazyExamples {

    public static Double ofLazy() {
        Lazy<Double> lazy = Lazy.of(Math::random);

        log.info("{}", lazy.isEvaluated());
        log.info("{}", lazy.get());

        return lazy.get();
    }

    public static void valLazy() {
        CharSequence value = Lazy.val(LazyExamples::printSomething, CharSequence.class);

        log.info("{}", value);
    }

    private static String printSomething() {
        return "RTM!";
    }
}