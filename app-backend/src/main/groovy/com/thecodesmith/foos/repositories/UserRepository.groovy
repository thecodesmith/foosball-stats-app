package com.thecodesmith.foos.repositories

import com.thecodesmith.foos.domain.User
import io.micronaut.data.annotation.*
import io.micronaut.data.repository.CrudRepository

@Repository
interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll()
    Optional<User> findByName(String name)
}
