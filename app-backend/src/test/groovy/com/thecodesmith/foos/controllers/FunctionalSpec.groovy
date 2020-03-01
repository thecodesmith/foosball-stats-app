package com.thecodesmith.foos.controllers

import com.thecodesmith.foos.domain.User
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class FunctionalSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @Inject @AutoCleanup @Client("/")
    RxHttpClient client

    def 'create a user'() {
        given:
        def user = new User(name: 'foo')

        when:
        def response = client.toBlocking().exchange(HttpRequest.POST('/users', user), User)

        then:
        response.status == HttpStatus.CREATED
        response.body().id > 0
    }
}
