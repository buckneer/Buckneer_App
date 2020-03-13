package com.miftarisimel.buckneer.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.miftarisimel.buckneer.data.UserRepository
import com.miftarisimel.buckneer.ui.common.BaseViewModel

class DashboardViewModel(onFailureListener: OnFailureListener,
                         userRepository: UserRepository) : BaseViewModel(onFailureListener) {


}