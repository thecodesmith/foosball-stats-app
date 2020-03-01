package com.thecodesmith.foos.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User {
    @Id @GeneratedValue Long id
    @Column(unique = true, nullable = false)
    String name
}