package com.mehroz.daggerhiltapp.data.repository

import com.mehroz.daggerhiltapp.data.model.PostData
import com.mehroz.daggerhiltapp.data.remote.ApiService
import com.mehroz.daggerhiltapp.domain.PostsRepository
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject

class PostsRepositoryImpl constructor(
    private val apiService: ApiService
) : PostsRepository {
    override suspend fun getPosts(): Response<List<PostData>> = apiService.getPosts()
}