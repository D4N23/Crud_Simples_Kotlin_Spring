package com.webservice.webservice.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID.randomUUID

@Entity
data class Note(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
      var id: Long = 0L, val title: String ="", val description: String ="") {
//    constructor() : this("","")
}