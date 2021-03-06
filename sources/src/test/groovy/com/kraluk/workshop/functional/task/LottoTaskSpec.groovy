package com.kraluk.workshop.functional.task

import spock.lang.Specification

class LottoTaskSpec extends Specification {

    def "should get six random number"() {
        when:
            def result = LottoTask.getLottoNumbers()

        then:
            result.size() == 6
            System.out.println(Arrays.toString(result.toArray()))

        where:
            i << (1..100)
    }
}
