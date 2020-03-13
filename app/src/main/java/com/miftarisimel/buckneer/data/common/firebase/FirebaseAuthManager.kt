package com.miftarisimel.buckneer.data.common.firebase

import com.google.android.gms.tasks.Task
import com.miftarisimel.buckneer.data.common.AuthManager
import com.miftarisimel.buckneer.data.common.toUnit
import com.miftarisimel.buckneer.data.firebase.common.auth

class FirebaseAuthManager : AuthManager {
    override fun signOut() {
        auth.signOut()
    }

    override fun signIn(email: String, password: String): Task<Unit> =
        auth.signInWithEmailAndPassword(email, password).toUnit()
}