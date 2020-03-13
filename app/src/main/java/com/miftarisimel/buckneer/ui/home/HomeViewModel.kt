package com.miftarisimel.buckneer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.data.ProjectsRepository
import com.miftarisimel.buckneer.data.common.SingleLiveEvent
import com.miftarisimel.buckneer.data.common.map
import com.miftarisimel.buckneer.models.Project
import com.miftarisimel.buckneer.ui.common.BaseViewModel

class HomeViewModel(onFailureListener: OnFailureListener,
                    private val projectsRepository: ProjectsRepository) : BaseViewModel(onFailureListener) {


    lateinit var uid: String
    lateinit var projects: LiveData<List<Project>>


    fun init(uid: String) {
        projects = projectsRepository.getProjects().map {
            it.sortedByDescending { it.timestampDate() }
        }
    }
}