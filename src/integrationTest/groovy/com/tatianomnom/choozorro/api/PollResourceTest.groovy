package com.tatianomnom.choozorro.api

import groovyx.net.http.RESTClient
import spock.lang.Specification

/**
 * TODO add description
 */
class PollResourceTest extends Specification {

    def "should create new poll"() {
        given:
        def polls = new RESTClient('http://localhost:8099/api/polls')

        when:
        def resp = polls.post([contentType : 'application/json', body: [description : 'test', options: ['a', 'b', 'c']]])

        then:
        resp.status == 200
    }
}
