package com.artimanton.wiki.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class Character (
    @PrimaryKey var id: String? = null,
    var name: String? = null,
    var status: String? = null,
    var species: String? = null,
    var type: String? = null,
    var gender: String? = null,
    var origin: NameUrl? = null,
    var location: NameUrl? = null,
    var image: String? = null,
    var episode: List<String>? = null,
    var url: String? = null,
    var created: String? = null

)