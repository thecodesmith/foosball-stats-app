package com.thecodesmith.foos.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
class Game {
    @Id @GeneratedValue Long id
    Date date
    @ManyToOne Region region
    @OneToOne Side side1
    @OneToOne Side side2
}