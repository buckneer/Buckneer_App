package com.miftarisimel.buckneer.ui.common

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.firebase.auth.FirebaseAuth
import com.miftarisimel.buckneer.data.firebase.common.auth

class AuthGuard(private val fragment: BaseFragment, f: (String) -> Unit) : LifecycleObserver {


    init {
        val user = auth.currentUser
        if(user == null) {
            fragment.goToLogin()
        } else {
            f(user.uid)
            fragment.lifecycle.addObserver(this)
        }
    }

    private val listener = FirebaseAuth.AuthStateListener {
        if(it.currentUser == null) {
            fragment.goToLogin()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        auth.addAuthStateListener(listener)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        auth.removeAuthStateListener(listener)
    }
}

fun BaseFragment.setupAuthGuard(f: (String) -> Unit) {
    AuthGuard(this, f)
}