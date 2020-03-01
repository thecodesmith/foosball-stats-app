package com.thecodesmith.foos.repositories

import com.thecodesmith.foos.domain.Team
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll()
    Optional<Team> findByName(String name)
}
