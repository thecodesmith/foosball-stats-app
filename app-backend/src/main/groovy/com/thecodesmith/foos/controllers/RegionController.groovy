package com.thecodesmith.foos.controllers

import com.thecodesmith.foos.domain.Region
import com.thecodesmith.foos.repositories.GameRepository
import com.thecodesmith.foos.repositories.RegionRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller('/api/regions')
class RegionController {

    @Inject RegionRepository regionRepository
    @Inject GameRepository gameRepository

    @Get('/')
    List<Region> getAll() {
        regionRepository.findAll()
    }

    @Post('/')
    HttpResponse create(@Body Region region) {
        HttpResponse.created(regionRepository.save(region))
    }

    @Get('/{id}')
    HttpResponse getById(@NotBlank Long id) {
        def region = regionRepository.findById(id)
        region.present ?
                HttpResponse.ok(region.get()) :
                HttpResponse.notFound()
    }

    @Get('/{id}/games')
    HttpResponse getGamesByRegion(@NotBlank Long id) {
        def region = regionRepository.findById(id)
        region.present ?
                HttpResponse.ok(gameRepository.findByRegion(region.get())) :
                HttpResponse.notFound()
    }

    @Put('/{id}')
    HttpResponse update(@NotBlank Long id, @Body Region region) {
        region.id = id
        regionRepository.save(region)
        HttpResponse.ok()
    }

    @Delete('/{id}')
    HttpResponse delete(@NotBlank Long id) {
        regionRepository.deleteById(id)
        HttpResponse.ok()
    }
}