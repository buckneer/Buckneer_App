package com.miftarisimel.buckneer.data

import android.net.Uri
import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import com.miftarisimel.buckneer.models.Project
import com.miftarisimel.buckneer.models.User

interface UserRepository {

    fun getUsers(): LiveData<List<User>>
    fun currentUid(): String?
    fun getUser(): LiveData<User>
    fun createUser(user: User, password: String): Task<Unit>
    fun setUserImage(uid: String, downloadUri: Uri) : Task<Unit>
    fun getUser(uid: String): LiveData<User>

}