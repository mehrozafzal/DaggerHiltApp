package com.mehroz.daggerhiltapp.domain

import com.mehroz.daggerhiltapp.data.model.PostData
import retrofit2.Response

interface PostsRepository {
    suspend fun getPosts(): Response<List<PostData>>
}