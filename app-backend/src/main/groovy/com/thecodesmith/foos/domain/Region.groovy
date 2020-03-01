package com.thecodesmith.foos.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Region {
    @Id @GeneratedValue Long id
    String name
}