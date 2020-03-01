package com.thecodesmith.foos.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Match {
    @Id @GeneratedValue Long id
    @OneToMany List<Game> games
}