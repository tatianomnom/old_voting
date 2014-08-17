package com.tatianomnom.choozorro.service

import spock.lang.Specification

/**
 * TODO add description
 */

class IdGeneratorSpec extends Specification {

    def "all generators should generate ID with correct length"() {

        expect:
        generator.generateId().length() == 32

        where:
        generator << [new UuidGenerator(), new SequentialIdGenerator()]
    }

    def "sequential generator should return sequential IDs"() {

        given:
        def sequentialGenerator = new SequentialIdGenerator()

        when:
        long firstId  = sequentialGenerator.generateId() as long
        long secondId = sequentialGenerator.generateId() as long
        long thirdId  = sequentialGenerator.generateId() as long

        then:
        secondId - firstId  == 1
        thirdId  - secondId == 1

    }
}
