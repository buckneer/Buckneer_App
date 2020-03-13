package com.miftarisimel.buckneer.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.ListItemProjectBinding
import com.miftarisimel.buckneer.models.Project
import com.miftarisimel.buckneer.ui.common.SimpleCallback

class HomeAdapter(private val listener: Listener) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.list_item_project, parent, false)
//
//        return ViewHolder(view)

        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ListItemProjectBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = this.projects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]

        with(holder.binding) {
           this.project = project
        }
    }


    interface Listener {
        fun sendMessage(projectId: String)
        fun loadBids(postId: String, position: Int)
        fun bid(projectId: String)
    }

    fun updatePosts(newProjects: List<Project>) {
        val diffResult = DiffUtil.calculateDiff(SimpleCallback(this.projects, newProjects) {it.id})
        this.projects = newProjects
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(val binding: ListItemProjectBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    var projects = listOf<Project>()

}