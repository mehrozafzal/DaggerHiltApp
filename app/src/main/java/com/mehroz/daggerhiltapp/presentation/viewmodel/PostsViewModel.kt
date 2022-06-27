package com.mehroz.daggerhiltapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehroz.daggerhiltapp.data.model.PostData
import com.mehroz.daggerhiltapp.domain.PostsUseCase
import com.mehroz.daggerhiltapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsUseCase: PostsUseCase
) : ViewModel() {

    private val _posts = MutableLiveData<Resource<List<PostData>>>()
    val posts: LiveData<Resource<List<PostData>>>
        get() = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _posts.postValue(Resource.loading(null))
            postsUseCase.getPosts().let {
                if (it.isSuccessful) {
                    _posts.postValue(Resource.success(it.body()))
                } else _posts.postValue(Resource.error(it.errorBody().toString(), null))
            }
        }
    }
}