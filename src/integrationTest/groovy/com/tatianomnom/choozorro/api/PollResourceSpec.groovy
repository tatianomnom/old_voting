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
        Sql.withInstance('jdbc:h2:./testdb', 'sa', '', 'org.h2.Driver') { sql ->
            //'create if not exists' shouldn't be there, because the db should be build from scratch
            sql.execute('''CREATE TABLE foo ( id INT, name VARCHAR(20) )''')
        }
    }

    def cleanupSpec() {
        Sql.withInstance('jdbc:h2:./testdb;AUTO_SERVER=TRUE', 'sa', '', 'org.h2.Driver') { sql ->
            sql.execute('''DROP ALL OBJECTS DELETE FILES''')
        }
    }

    def "should create new poll and redirect to it"() {

        when:
        def resp = polls.post([body: [description: 'test', options: ['a', 'b', 'c']]])

        then:
        resp.status == 200
        resp.data.description == 'aaa'
        resp.data.options == ['a', 'b']
    }

}
