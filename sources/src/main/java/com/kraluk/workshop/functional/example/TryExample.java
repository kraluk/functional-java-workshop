package com.kraluk.workshop.functional.example;

import com.kraluk.workshop.functional.core.enums.Result;
import com.kraluk.workshop.functional.core.exception.WorkshopException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.Collections;

import javaslang.control.Try;

import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;
import static javaslang.Patterns.Failure;
import static javaslang.Patterns.Success;
import static javaslang.Predicates.instanceOf;

/**
 * Try Examples
 *
 * @author lukasz
 */
public class TryExample {
    private static final Logger log = LoggerFactory.getLogger(TryExample.class);

    public static int simpleTry() {
        return Try.of(TryExample::someWorkWithoutResult)
            .getOrElseThrow(e -> new WorkshopException(e));
    }

    public static Result tryWithResult() {
        return Try.of(TryExample::someWork)
            .recover(e -> Match(e).of(
                Case(instanceOf(IllegalArgumentException.class), Result.FIRST),
                Case(instanceOf(FileNotFoundException.class), Result.SECOND),
                Case(instanceOf(NullPointerException.class), Result.SECOND_OR_THIRD)
            ))
            .getOrElse(Result.NAN);
    }

    public static void tryWithFailureType() {
        Try<Object> operation = Try.of(() -> {
            //throw new RuntimeException();
            return Collections.emptyEnumeration();
        });

        String value = Match(operation).of(
            Case(Success($(1)), "Sukces, ktorego nie bedzie :-("),
            Case(Success($()), "Domyslny sukces!"),
            Case(Success($(e -> e instanceof Integer && (Integer) e > 500)),
                e -> String.format("[][][]%s[][][]", e)),
            Case(Failure($(instanceOf(WorkshopException.class))), "Lorkszopowy blad!"),
            Case(Failure($()), "Domyslny blad!")
        );

        log.info("{}", value);
    }

    public static void main(String[] args) {
        tryWithFailureType();
    }

    private static Result someWork() {
        throw new IllegalArgumentException("Hello!");
    }

    private static int someWorkWithoutResult() {
        throw new IllegalArgumentException("World!");
    }
}