package com.miftarisimel.buckneer.data.firebase

import android.net.Uri
import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.miftarisimel.buckneer.data.UserRepository
import com.miftarisimel.buckneer.data.common.map
import com.miftarisimel.buckneer.data.common.toUnit
import com.miftarisimel.buckneer.data.firebase.common.auth
import com.miftarisimel.buckneer.data.firebase.common.database
import com.miftarisimel.buckneer.data.firebase.common.liveData
import com.miftarisimel.buckneer.models.Project
import com.miftarisimel.buckneer.models.User

class FirebaseUserRepository : UserRepository {


    override fun getUsers(): LiveData<List<User>> =
        database.child("users").liveData().map {
            it.children.map { it.asUser()!! }
        }

    override fun currentUid(): String? = FirebaseAuth.getInstance().currentUser?.uid

    override fun getUser(): LiveData<User> = getUser(currentUid()!!)

    override fun createUser(user: User, password: String): Task<Unit> =
        auth.createUserWithEmailAndPassword(user.email, password).onSuccessTask {
            database.child("users").child(it!!.user!!.uid).setValue(user)
        }.toUnit()

    override fun setUserImage(uid: String, downloadUri: Uri): Task<Unit> =
        database.child("images").child(uid).push()
        .setValue(downloadUri.toString()).toUnit()

    override fun getUser(uid: String): LiveData<User> =
        database.child("users").child(uid).liveData().map {
            it.asUser()!!
        }


    private fun DataSnapshot.asUser(): User? =
        getValue(User::class.java)?.copy(uid = key!!)
}