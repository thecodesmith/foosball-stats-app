package com.thecodesmith.foos.controllers

import com.thecodesmith.foos.domain.Color
import com.thecodesmith.foos.repositories.ColorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller('/api/colors')
class ColorController {

    @Inject ColorRepository colorRepository

    @Get('/')
    List<Color> getAll() {
        colorRepository.findAll()
    }

    @Post('/')
    HttpResponse create(@Body Color color) {
        HttpResponse.created(colorRepository.save(color))
    }

    @Get('/{id}')
    HttpResponse getGameById(@NotBlank Long id) {
        def result = colorRepository.findById(id)
        result.present ?
                HttpResponse.ok(result.get()) :
                HttpResponse.notFound()
    }

    @Put('/{id}')
    HttpResponse update(@NotBlank Long id, @Body Color color) {
        color.id = id
        colorRepository.save(color)
        HttpResponse.ok()
    }

    @Delete('/{id}')
    HttpResponse delete(@NotBlank Long id) {
        colorRepository.deleteById(id)
        HttpResponse.ok()
    }
}