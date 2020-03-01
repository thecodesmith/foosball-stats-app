package com.thecodesmith.foos.controllers

import com.thecodesmith.foos.domain.Game
import com.thecodesmith.foos.repositories.GameRepository
import com.thecodesmith.foos.repositories.RegionRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller('/api/games')
class GameController {

    @Inject GameRepository gameRepository
    @Inject RegionRepository regionRepository

    @Get('/')
    List<Game> getAll() {
        gameRepository.findAll()
    }

    @Post('/')
    HttpResponse create(@Body Game game) {
        HttpResponse.created(gameRepository.save(game))
    }

    @Get('/{id}')
    HttpResponse getGameById(@NotBlank Long id) {
        def result = gameRepository.findById(id)
        result.present ?
                HttpResponse.ok(result.get()) :
                HttpResponse.notFound()
    }

    @Put('/{id}')
    HttpResponse update(@NotBlank Long id, @Body Game game) {
        game.id = id
        gameRepository.save(game)
        HttpResponse.ok()
    }

    @Delete('/{id}')
    HttpResponse delete(@NotBlank Long id) {
        gameRepository.deleteById(id)
        HttpResponse.ok()
    }
}