package com.tatianomnom.choozorro

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.tatianomnom.choozorro.api.PollCommand
import spock.lang.Shared
import spock.lang.Specification

/**
 * TODO add description
 * TODO extract JSONs to resource files?
 */
class PollCommandSpec extends Specification {

    @Shared
    def objectMapper = new ObjectMapper()

    def "should serialize correctly"() {

        given:
        def pollCommand = new PollCommand('Where to go?', ['zoo', 'gym', 'cafe'], null, null)

        expect:
        objectMapper.writeValueAsString(pollCommand) == """{"description":"Where to go?","options":["zoo","gym","cafe"]}"""

    }

    //TODO separate test for optional parameters?
    def "should deserialize correctly"() {

        expect:
        objectMapper.readValue(json, PollCommand) == new PollCommand(description, options, url, null)

        where:
        json                                                                                      || description                 | options          | url
        """{"description":"What shall we do tonight?","options":["eat", "drink"],"url":"http"}""" || 'What shall we do tonight?' | ['eat', 'drink'] | 'http'
        """{"options":["eat", "drink"],"description":"What shall we do tonight?"}"""              || 'What shall we do tonight?' | ['eat', 'drink'] | null
        """{"options":  ["yes", "no"],   "description"  :"?"}"""                                  || '?'                         | ['yes', 'no']    | null

    }

    //TODO add a couple of 'urls' below just in case
    def "should not deserialize from invalid json"() {

        when:
        objectMapper.readValue(json, PollCommand)

        then:
        thrown JsonParseException

        where:
        json << ["""{"description":"A?","options":["B", "C"}""",
                 """{"description":A?","options":["B", "C"]}"""]

    }

    def "should not deserialize from incomplete json"() {

        when:
        println objectMapper.readValue(json, PollCommand)

        then:
        thrown JsonMappingException

        where:
        json << ["""{"description":"A?","ptions":["B", "C"]}""",
                 """{"escription":"A?","options":["B", "C"]}""",
                 """{"description":"A?"}"""]

    }

}
