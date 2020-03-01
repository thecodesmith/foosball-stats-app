package com.thecodesmith.foos.repositories

import com.thecodesmith.foos.domain.Side
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.annotation.EntityGraph
import io.micronaut.data.repository.CrudRepository

@Repository
interface SideRepository extends CrudRepository<Side, Long> {
    @EntityGraph(attributePaths = ['team'])
    List<Side> findAll()
}
