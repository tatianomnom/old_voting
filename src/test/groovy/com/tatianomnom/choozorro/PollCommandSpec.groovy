package com.tatianomnom.choozorro

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.tatianomnom.choozorro.api.PollCommand
import spock.lang.Shared
import spock.lang.Specification

/**
 * TODO add description
 */
class PollCommandSpec extends Specification {

    @Shared
    private def objectMapper = new ObjectMapper()

    @Shared
    private def jsons

    def setupSpec() {
        def props = new Properties()
        this.getClass().getResource('/poll_sample_jsons.properties').withInputStream {
            props.load(it)
        }
        jsons = new ConfigSlurper().parse(props)
    }

    def "should serialize correctly"() {

        given:
        def pollCommand = new PollCommand('Where to go?', ['zoo', 'gym', 'cafe'], null, null)

        expect:
        objectMapper.writeValueAsString(pollCommand) == jsons['withoutUrlAndMaxSubmits']

    }

    def "should deserialize correctly"() {

        expect:
        objectMapper.readValue(json as String, PollCommand) == new PollCommand(description, options, url, maxSubmits)

        where:
        json                              || description    | options                | url                     | maxSubmits
        jsons['full']                     || 'Where to go?' | ['zoo', 'gym', 'cafe'] | 'http://example.com/abc'| 5
        jsons['withoutUrl']               || 'Where to go?' | ['zoo', 'gym', 'cafe'] | null                    | 5
        jsons['withoutMaxSubmits']        || 'Where to go?' | ['zoo', 'gym', 'cafe'] | 'http://example.com/abc'| null
        jsons['withoutUrlAndMaxSubmits']  || 'Where to go?' | ['zoo', 'gym', 'cafe'] | null                    | null
        //hover on values in square brackets and praise IDEA :)
    }

    //TODO add a couple of 'urls' below just in case
    def "should not deserialize from invalid json"() {

        when:
        objectMapper.readValue(json as String, PollCommand)

        then:
        thrown JsonParseException

        where:
        json << ["""{"description":"A?","options":["B", "C"}""",
                 """{"description":A?","options":["B", "C"]}"""]

    }

    //TODO this is not too helpful due to the constraints of Jackson, see properties file comments
    def "should not deserialize from incomplete json"() {

        when:
        println objectMapper.readValue(json as String, PollCommand)

        then:
        thrown JsonMappingException

        where:
        json << [jsons['onlyDescription'], jsons['onlyDescriptionAndMaxSubmits']]

    }

}
