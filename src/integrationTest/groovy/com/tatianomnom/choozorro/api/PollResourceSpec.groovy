package com.tatianomnom.choozorro.api

import groovyx.net.http.RESTClient
import spock.lang.Specification

import static groovyx.net.http.ContentType.JSON

/**
 * TODO add description
 */
class PollResourceSpec extends Specification {

    def "should create new poll"() {
        given:
        def polls = new RESTClient('http://localhost:8099/api/polls', JSON)

        when:
        def resp = polls.post([body: [description: 'test', options: ['a', 'b', 'c']]])

        then:
        resp.status == 200
        resp.data.url == '00000000000000000000000000000001'
    }
}
