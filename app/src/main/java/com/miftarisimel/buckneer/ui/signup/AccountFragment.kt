package com.miftarisimel.buckneer.ui.signup

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentAccountBinding
import com.miftarisimel.buckneer.ui.common.BaseFragment

class AccountFragment : BaseFragment() {




    private lateinit var mViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAccountBinding.inflate(inflater)


        val name = AccountFragmentArgs.fromBundle(arguments!!).fullName
        val profession = AccountFragmentArgs.fromBundle(arguments!!).profession
        val phone = AccountFragmentArgs.fromBundle(arguments!!).mobileNumber

        mViewModel = initViewModel()

        binding.finishButtonToHome.setOnClickListener {
            this.findNavController().navigate(R.id.navigation_home)
            //TODO register user here in view model
            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            when {
                name == null || profession == null || phone == null  -> Log.e("AccountFragment", "Value is null")
                else -> mViewModel.onRegister(name, email, username, password, phone, profession)
            }

            mViewModel.goToHomeScreen.observe(viewLifecycleOwner, Observer {
                this.findNavController().navigate(R.id.navigation_home)
            })
        }

        return binding.root
        
    }


}
