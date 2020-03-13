package com.miftarisimel.buckneer

import android.app.Application
import com.miftarisimel.buckneer.data.common.firebase.FirebaseAuthManager
import com.miftarisimel.buckneer.data.firebase.FirebaseProjectsRepository
import com.miftarisimel.buckneer.data.firebase.FirebaseUserRepository

class BuckneerApp : Application() {
    val usersRepo by lazy { FirebaseUserRepository() }
    val projectsRepo by lazy { FirebaseProjectsRepository() }
    val authManager by lazy { FirebaseAuthManager() }
}