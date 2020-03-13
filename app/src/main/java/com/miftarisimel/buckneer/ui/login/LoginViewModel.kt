package com.miftarisimel.buckneer.ui.login

import android.app.Application
import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.data.common.AuthManager
import com.miftarisimel.buckneer.data.common.SingleLiveEvent
import com.miftarisimel.buckneer.ui.common.BaseViewModel
import com.miftarisimel.buckneer.ui.common.CommonViewModel

class LoginViewModel(val authManager: AuthManager,val app: Application,val commonViewModel: CommonViewModel, onFailureListener: OnFailureListener) : BaseViewModel(onFailureListener) {


    private val _goToHomeScreen = SingleLiveEvent<Unit>()
    val goToHomeScreen: LiveData<Unit> = _goToHomeScreen

    fun onLogin(email: String, password: String) {
        if(validate(email, password)) {
            authManager.signIn(email, password).addOnSuccessListener {
                _goToHomeScreen.value = Unit
            }.addOnFailureListener(onFailureListener)
        } else {
            commonViewModel.setErrorMessage(app.getString(R.string.please_enter_email_and_password))
        }
    }

    private fun validate(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()

}
