package com.mehroz.daggerhiltapp.presentation.view

import com.mehroz.daggerhiltapp.data.remote.ApiService
import com.mehroz.daggerhiltapp.data.repository.PostsRepositoryImpl
import com.mehroz.daggerhiltapp.domain.PostsRepository
import com.mehroz.daggerhiltapp.domain.PostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object PostsModule {

    @Provides
    @ActivityRetainedScoped
    fun providePostsRepository(
        apiService: ApiService
    ): PostsRepository {
        return PostsRepositoryImpl(apiService)
    }

/*    @Provides
    @ActivityRetainedScoped
    fun providePostUseCaseRepository(
        postsRepository: PostsRepository
    ): PostsUseCase {
        return PostsUseCase(postsRepository)
    }*/
}
