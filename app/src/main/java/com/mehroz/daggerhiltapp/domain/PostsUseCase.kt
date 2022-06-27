package com.mehroz.daggerhiltapp.domain

import com.mehroz.daggerhiltapp.data.model.PostData
import retrofit2.Response
import javax.inject.Inject

class PostsUseCase @Inject constructor(private val postsRepository: PostsRepository) {
    suspend fun getPosts(): Response<List<PostData>> = postsRepository.getPosts()
}