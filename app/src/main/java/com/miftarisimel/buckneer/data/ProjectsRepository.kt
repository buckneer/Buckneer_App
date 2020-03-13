package com.miftarisimel.buckneer.data

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.miftarisimel.buckneer.models.Project

interface ProjectsRepository {

    fun getProjects(): LiveData<List<Project>>
    fun createProject(uid: String, project: Project): Task<Unit>
    fun copyProject(uid: String, project: Project) : Task<Unit>
    fun getProjectsByUser(uid: String): LiveData<List<Project>>

}