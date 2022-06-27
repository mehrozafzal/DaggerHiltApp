package com.mehroz.daggerhiltapp.data.model

import com.squareup.moshi.Json

data class PostData(
    @field:Json(name = "body")
    val body: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "userId")
    val userId: Int
)
