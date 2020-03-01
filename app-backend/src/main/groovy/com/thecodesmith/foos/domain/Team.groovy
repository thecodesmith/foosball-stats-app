package com.thecodesmith.foos.domain

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Team {
    @Id @GeneratedValue Long id
    String name
    @OneToMany(fetch = FetchType.EAGER)
    List<User> users
}