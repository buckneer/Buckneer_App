package com.miftarisimel.buckneer.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.ui.common.BaseViewModel

class NotificationsViewModel(onFailureListener: OnFailureListener) : BaseViewModel(onFailureListener) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


}