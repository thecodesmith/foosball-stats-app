package com.thecodesmith.foos.controllers

import com.thecodesmith.foos.domain.User
import com.thecodesmith.foos.repositories.UserRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

import javax.inject.Inject
import javax.validation.constraints.NotBlank

@Controller('/api/users')
class UserController {

    @Inject UserRepository userRepository

    @Get('/')
    List<User> getAll() {
        userRepository.findAll()
    }

    @Post('/')
    HttpResponse create(@Body User user) {
        HttpResponse.created(userRepository.save(user))
    }

    @Get('/{id}')
    HttpResponse getUserById(@NotBlank Long id) {
        def result = userRepository.findById(id)
        result.present ?
                HttpResponse.ok(result.get()) :
                HttpResponse.notFound()
    }

    @Put('/{id}')
    HttpResponse update(@NotBlank Long id, @Body User user) {
        user.id = id
        userRepository.save(user)
        HttpResponse.ok()
    }

    @Delete('/{id}')
    HttpResponse delete(@NotBlank Long id) {
        userRepository.deleteById(id)
        HttpResponse.ok()
    }
}