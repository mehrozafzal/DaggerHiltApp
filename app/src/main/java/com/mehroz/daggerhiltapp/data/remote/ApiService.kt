package com.mehroz.daggerhiltapp.data.remote

import com.mehroz.daggerhiltapp.data.model.PostData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostData>>
}