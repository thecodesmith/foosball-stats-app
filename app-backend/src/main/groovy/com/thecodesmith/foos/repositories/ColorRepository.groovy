package com.thecodesmith.foos.repositories

import com.thecodesmith.foos.domain.Color
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ColorRepository extends CrudRepository<Color, Long> {
    List<Color> findAll()
    Optional<Color> findByName(String name)
}
