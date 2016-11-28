package com.kraluk.workshop.functional.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Extended Collections Examples
 *
 * @author lukasz
 */
@Slf4j
public class ExtendedCollectionExamples {

    public static java.util.List<Integer> filterValues(int... ints) {
        return javaslang.collection.List.ofAll(ints)
            .filter(e -> e % 2 == 0)
            .toJavaList();
    }

    public static java.util.List<Double> getSomeRandomDoubles() {
        java.util.List<Double> doubles = new java.util.ArrayList<>();

        for (double random : javaslang.collection.Stream.continually(Math::random)
            .take(666)
            .filter(e -> e > 0.5 && e < 0.6)) {
            doubles.add(random);
        }

        return doubles;
    }
}