package com.mehroz.daggerhiltapp.presentation.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mehroz.daggerhiltapp.R
import com.mehroz.daggerhiltapp.data.model.PostData
import com.mehroz.daggerhiltapp.presentation.viewmodel.PostsViewModel
import com.mehroz.daggerhiltapp.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsActivity : AppCompatActivity() {
    private val postsViewModel: PostsViewModel by viewModels()
    private var postsRv: RecyclerView? = null
    private var postsAdapter: PostsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setupUI()
        observePosts()
    }

    private fun setupUI() {
        postsRv = findViewById(R.id.activityPosts_postsRv)
        postsRv?.layoutManager = LinearLayoutManager(this)
        postsAdapter = PostsAdapter(arrayListOf())
        postsRv?.addItemDecoration(
            DividerItemDecoration(
                postsRv?.context,
                (postsRv?.layoutManager as LinearLayoutManager).orientation
            )
        )
        postsRv?.adapter = postsAdapter
    }

    private fun observePosts(){
        postsViewModel.posts.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { posts -> renderList(posts) }
                    postsRv?.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    postsRv?.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(posts: List<PostData>) {
        postsAdapter?.addData(posts)
        postsAdapter?.notifyDataSetChanged()
    }
}