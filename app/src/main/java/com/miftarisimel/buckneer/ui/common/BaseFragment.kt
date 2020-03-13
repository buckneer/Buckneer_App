package com.miftarisimel.buckneer.ui.common

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.miftarisimel.buckneer.BuckneerApp
import com.miftarisimel.buckneer.R

abstract class BaseFragment : Fragment() {

    lateinit var commonViewModel: CommonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        commonViewModel = ViewModelProviders.of(this).get(CommonViewModel::class.java)
        commonViewModel.errorMessage.observe(this, Observer {
            it?.let {
                Toast.makeText(activity!!, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    inline fun <reified T : BaseViewModel> initViewModel(): T =
        ViewModelProviders.of(this, ViewModelFactory(
            BuckneerApp(),
            commonViewModel,
            commonViewModel)).get(T::class.java)

    companion object {
        const val TAG = "BaseFragment"
    }

    fun goToLogin() {
        this.findNavController().navigate(R.id.loginFragment)
    }
}