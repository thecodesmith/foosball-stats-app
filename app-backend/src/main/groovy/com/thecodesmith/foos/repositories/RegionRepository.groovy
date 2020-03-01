package com.thecodesmith.foos.repositories

import com.thecodesmith.foos.domain.Region
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findAll()
    Optional<Region> findByName(String name)
}
