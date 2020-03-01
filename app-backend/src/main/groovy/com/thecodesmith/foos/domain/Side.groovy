package com.thecodesmith.foos.domain

import javax.annotation.Nullable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Side {
    @Id @GeneratedValue Long id
    @OneToOne @Nullable User user
    @OneToOne @Nullable Team team
    @OneToOne Color color
    Integer score
    Boolean win
}