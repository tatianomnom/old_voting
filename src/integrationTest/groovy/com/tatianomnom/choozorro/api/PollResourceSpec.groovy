package com.tatianomnom.choozorro.api

import groovy.sql.Sql
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static groovyx.net.http.ContentType.JSON

/**
 * TODO add description
 */

@Stepwise
class PollResourceSpec extends Specification {

    private static final String BASEURL = 'http://localhost:8099/api'

    @Shared
    private def polls = new RESTClient("$BASEURL/polls", JSON)

    def setupSpec() {
        Sql.withInstance('jdbc:h2:./build/testdb;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS TESTDB', 'sa', '', 'org.h2.Driver') { sql ->
            sql.execute('''create table PUBLIC.FOO ( id int, name VARCHAR(20) )''')
        }
    }

    def cleanupSpec() {
        //TODO ideally DB cleanup should be done here, not by placing db to ./build directory
    }

    def "should create new poll"() {

        when:
        def resp = polls.post([body: [description: 'test', options: ['a', 'b', 'c']]])

        then:
        resp.status == 201
        //TODO is it possible to get only the value?
        String fullHeader = resp.headers['Location']
        def header = fullHeader.split(': ')[1].trim()
        header == "$BASEURL/polls/00000000000000000000000000000001"
    }

    def "should find created poll"() {

        when:
        //TODO consistent uri chunks in http client, looks like 'path' overwrites previous relative paths
        def resp = polls.get([path : 'polls/00000000000000000000000000000001'])

        then:
        resp.data.description == 'aaa'
        resp.data.options == ['a', 'b']
    }
}
