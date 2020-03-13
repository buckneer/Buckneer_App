package com.miftarisimel.buckneer.ui.signup

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.data.UserRepository
import com.miftarisimel.buckneer.data.common.SingleLiveEvent
import com.miftarisimel.buckneer.models.User
import com.miftarisimel.buckneer.ui.common.BaseViewModel
import com.miftarisimel.buckneer.ui.common.CommonViewModel

class AccountViewModel(private val commonViewModel: CommonViewModel,
                       private val app: Application,
                       onFailureListener: OnFailureListener,
                       private val usersRepo: UserRepository
) : BaseViewModel(onFailureListener) {

    private val _goToHomeScreen = SingleLiveEvent<Unit>()
    val goToHomeScreen = _goToHomeScreen
    private val _goBackToEmailScreen = SingleLiveEvent<Unit>()


    fun onRegister(name: String,
                   email: String,
                   username: String,
                   password: String,
                   mobilePhone: String,
                   profession: String) {

        if(name.isNotBlank() &&
            email.isNotEmpty() &&
            username.isNotEmpty() &&
            password.isNotEmpty() &&
            mobilePhone.isNotEmpty() &&
            profession.isNotEmpty()) {

            usersRepo.createUser(mkUser(email, username, profession, name, mobilePhone), password).addOnSuccessListener {
                _goToHomeScreen.call()
            }.addOnFailureListener (onFailureListener)
            Log.e("RegisterViewModel", "onRegister: email, password or username is null")
            _goBackToEmailScreen.call()
        }

    }


    private fun mkUser(email: String, username: String, profession: String, name: String, mobilePhone: String): User {
        return User(email = email,
            username = username,
            profession = profession,
            name = name,
            mobileNumber = mobilePhone)
    }

}
