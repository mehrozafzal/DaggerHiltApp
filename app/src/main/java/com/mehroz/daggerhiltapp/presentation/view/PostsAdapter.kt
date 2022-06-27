package com.mehroz.daggerhiltapp.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mehroz.daggerhiltapp.R
import com.mehroz.daggerhiltapp.data.model.PostData


class PostsAdapter(
    posts: ArrayList<PostData?>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var postsList: ArrayList<PostData?>? = posts

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = itemView.findViewById(R.id.itemPost_title)
        var post: TextView = itemView.findViewById(R.id.itemPost_post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = postsList?.get(position)
        currentItem?.let {
            updateView(currentItem, viewHolder as ViewHolder)
        }
    }

    private fun updateView(currentItem: PostData, viewHolder: ViewHolder) {
        viewHolder.title.text = currentItem.title
        viewHolder.post.text = currentItem.body
    }

    override fun getItemCount(): Int {
        return postsList?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun addData(list: List<PostData>) {
        postsList?.addAll(list)
    }
}


