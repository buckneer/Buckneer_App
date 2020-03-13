package com.miftarisimel.buckneer.data.firebase

import android.app.usage.UsageEvents
import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.miftarisimel.buckneer.data.ProjectsRepository
import com.miftarisimel.buckneer.data.common.*
import com.miftarisimel.buckneer.data.firebase.common.FirebaseLiveData
import com.miftarisimel.buckneer.data.firebase.common.database
import com.miftarisimel.buckneer.models.Project

class FirebaseProjectsRepository : ProjectsRepository {
    override fun getProjects(): LiveData<List<Project>> =
        FirebaseLiveData(database.child("projects")).map {
            it.children.map { it.asProject()!! }
        }

    override fun getProjectsByUser(uid: String): LiveData<List<Project>> =
        FirebaseLiveData(database.child("user-projects").child(uid)).map {
            it.children.map { it.asProject()!! }
        }

    override fun createProject(uid: String, project: Project): Task<Unit> {
        val reference = database.child("projects").push()
        return reference.setValue(project).toUnit().addOnSuccessListener {
            EventBus.publish(Event.CreateProject(project.copy(id = reference.key!!)))
        }
    }

    override fun copyProject(uid: String, project: Project) : Task<Unit> {
        val userReference = database.child("user-projects").child(uid).push()
        return userReference.setValue(project).toUnit().addOnSuccessListener {
            EventBus.publish(Event.CreateProject(project.copy(id = userReference.key!!)))
        }
    }




    private fun DataSnapshot.asProject(): Project? =
        getValue(Project::class.java)?.copy(id = key!!)

    //TODO finish the .child(project.category.toString())
}