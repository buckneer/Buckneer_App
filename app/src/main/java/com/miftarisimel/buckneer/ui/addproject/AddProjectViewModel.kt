package com.miftarisimel.buckneer.ui.addproject

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.data.common.SingleLiveEvent
import com.miftarisimel.buckneer.data.firebase.FirebaseProjectsRepository
import com.miftarisimel.buckneer.data.firebase.FirebaseUserRepository
import com.miftarisimel.buckneer.models.Category
import com.miftarisimel.buckneer.models.Project
import com.miftarisimel.buckneer.models.User
import com.miftarisimel.buckneer.ui.common.BaseViewModel

class AddProjectViewModel(
    private val projectsRepository: FirebaseProjectsRepository,
    private val usersRepository: FirebaseUserRepository,
    onFailureListener: OnFailureListener) : BaseViewModel(onFailureListener) {

    private val _shareCompletedEvent = SingleLiveEvent<Unit>()
    val shareCompletedEvent = _shareCompletedEvent
    val user = usersRepository.getUser()

    fun share(user: User, title: String, description: String, category: Category) {
        projectsRepository.createProject(user.uid, mkProject(user, title, description, category))
            .addOnSuccessListener {
                projectsRepository.copyProject(user.uid, mkProject(user, title, description, category))
                    .addOnSuccessListener {
                        _shareCompletedEvent.call()
                    }.addOnFailureListener(onFailureListener)
            }.addOnFailureListener(onFailureListener)

    }

    fun mkProject(user: User, title: String, description: String, category: Category) : Project {
        return Project(
            uid = user.uid,
            name = user.name,
            title = title,
            description = description,
            category = Category.ANDROID
        )
    }


}
