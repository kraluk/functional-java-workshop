package com.kraluk.workshop.functional

import spock.lang.Specification

class ApplicationSpec extends Specification {

    def "running main method should not thrown any exception"() {

        when:
            Application.main()

        then:
            noExceptionThrown()
    }
}