package com.thecodesmith

import com.thecodesmith.foos.domain.*
import com.thecodesmith.foos.repositories.*
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.event.annotation.EventListener
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

import javax.inject.Inject
import javax.inject.Singleton

@Slf4j
@Singleton
@CompileStatic
@OpenAPIDefinition(
        info = @Info(
                title = 'Foosball Stats App',
                version = '1.0.0-a.1',
                description = 'Foosball game tracking and stats'
        )
)
class Application {

    static void main(String[] args) {
        Micronaut.run(Application)
    }

    @Inject UserRepository userRepository
    @Inject GameRepository gameRepository
    @Inject TeamRepository teamRepository
    @Inject SideRepository sideRepository
    @Inject ColorRepository colorRepository
    @Inject RegionRepository regionRepository

    @EventListener
    void init(StartupEvent event) {
        log.info 'Populating test data'

        def yellow = new Color(name: 'yellow')
        def black = new Color(name: 'black')
        colorRepository.saveAll([yellow, black])

        def eau = new Region(name: 'Eau Claire')
        def ktw = new Region(name: 'Katowice')
        regionRepository.saveAll([eau, ktw])

        def user1 = new User(name: 'brian')
        def user2 = new User(name: 'david')
        def user3 = new User(name: 'tj')
        def user4 = new User(name: 'tom')
        userRepository.saveAll([user1, user2, user3, user4])

        def team1 = new Team(users: [user1, user3])
        def team2 = new Team(users: [user2, user4])
        teamRepository.saveAll([team1, team2])

        def side1 = new Side(team: team1, color: yellow, score: 3, win: false)
        def side2 = new Side(team: team2, color: black, score: 5, win: true)
        def side3 = new Side(team: team1, color: yellow, score: 5, win: true)
        def side4 = new Side(team: team2, color: black, score: 2, win: false)
        def side5 = new Side(user: user1, color: yellow, score: 5, win: true)
        def side6 = new Side(user: user2, color: black, score: 2, win: false)
        sideRepository.saveAll([side1, side2, side3, side4, side5, side6])

        def game1 = new Game(date: now(), side1: side1, side2: side2, region: eau)
        def game2 = new Game(date: now(), side1: side3, side2: side4, region: eau)
        def game3 = new Game(date: now(), side1: side5, side2: side6, region: eau)
        gameRepository.saveAll([game1, game2, game3])
    }

    static Date now() {
        new Date()
    }
}