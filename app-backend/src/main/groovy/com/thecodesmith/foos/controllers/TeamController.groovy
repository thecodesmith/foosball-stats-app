package com.thecodesmith.foos.controllers

import com.thecodesmith.foos.domain.Team
import com.thecodesmith.foos.repositories.TeamRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller('/api/teams')
class TeamController {

    @Inject TeamRepository teamRepository

    @Get('/')
    List<Team> getAll() {
        teamRepository.findAll()
    }

    @Post('/')
    HttpResponse create(@Body Team team) {
        HttpResponse.created(teamRepository.save(team))
    }

    @Get('/{id}')
    HttpResponse getUserById(@NotBlank Long id) {
        def result = teamRepository.findById(id)
        result.present ?
                HttpResponse.ok(result.get()) :
                HttpResponse.notFound()
    }

    @Put('/{id}')
    HttpResponse update(@NotBlank Long id, @Body Team team) {
        team.id = id
        teamRepository.save(team)
        HttpResponse.ok()
    }

    @Delete('/{id}')
    HttpResponse delete(@NotBlank Long id) {
        teamRepository.deleteById(id)
        HttpResponse.ok()
    }
}