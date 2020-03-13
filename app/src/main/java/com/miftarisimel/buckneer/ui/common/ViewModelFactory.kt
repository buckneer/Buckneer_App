package com.miftarisimel.buckneer.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.BuckneerApp
import com.miftarisimel.buckneer.ui.addproject.AddProjectViewModel
import com.miftarisimel.buckneer.ui.home.HomeViewModel
import com.miftarisimel.buckneer.ui.login.LoginViewModel
import com.miftarisimel.buckneer.ui.notifications.NotificationsViewModel
import com.miftarisimel.buckneer.ui.signup.AccountViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val app: BuckneerApp,
                       private val commonViewModel: CommonViewModel,
                       private val onFailureListener: OnFailureListener
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val usersRepo = app.usersRepo
        val projectsRepo = app.projectsRepo
        val authManager = app.authManager
//        val notificationsRepo = app.notificationsRepo
//        val searchRepo = app.searchRepo

        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(onFailureListener, projectsRepo) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(authManager, app, commonViewModel, onFailureListener) as T
            modelClass.isAssignableFrom(NotificationsViewModel::class.java) -> NotificationsViewModel(onFailureListener) as T
            modelClass.isAssignableFrom(AccountViewModel::class.java) -> AccountViewModel(commonViewModel, app, onFailureListener, usersRepo) as T
            modelClass.isAssignableFrom(AddProjectViewModel::class.java) -> AddProjectViewModel(projectsRepo, usersRepo, onFailureListener) as T
            else -> error("Unknown view model class $modelClass")
        }
    }
}