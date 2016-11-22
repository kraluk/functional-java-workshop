package com.kraluk.workshop.functional.slang

import javaslang.control.Try
import spock.lang.Specification

class TrySpec extends Specification {

    def "if divisor is non zero, then operation should return a proper result"() {
        when:
            def tried = TryExamples.divide(dividend, divisor)

        then:
            result == tried.get()

        where:
            dividend || divisor || result
            0        || 2       || 0
            4        || 2       || 2
    }

    def "if divisor is zero, then an ArithmeticException (wrapped in Try.NonFatalException) should be thrown"() {
        when:
            TryExamples.divide(dividend, divisor).get()

        then:
            thrown Try.NonFatalException

        where:
            dividend || divisor
            0        || 0
            4        || 0
    }
}