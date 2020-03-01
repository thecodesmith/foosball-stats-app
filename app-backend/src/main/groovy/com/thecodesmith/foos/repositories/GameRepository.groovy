package com.thecodesmith.foos.repositories

import com.thecodesmith.foos.domain.Game
import com.thecodesmith.foos.domain.Region
import io.micronaut.data.annotation.*
import io.micronaut.data.repository.CrudRepository

@Repository
interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAll()
    List<Game> findByRegion(Region region)
}
