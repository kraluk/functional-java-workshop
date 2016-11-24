package com.kraluk.workshop.functional.slang;

import lombok.extern.slf4j.Slf4j;

import javaslang.collection.Stream;

/**
 * Lazy Playground
 *
 * @author lukasz
 */
@Slf4j
public class Lazies {

    public static long someVeryHardCalculation() {
        Number sum =
            Stream.from(1L)
                .take(1_000_000_000L)
                .map(e -> e * e)
                .sum();

        return (long) sum;
    }

    public static void main(String[] args) {
        log.info("{}", someVeryHardCalculation());
    }
}
