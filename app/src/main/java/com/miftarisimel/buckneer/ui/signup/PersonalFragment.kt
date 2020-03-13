package com.miftarisimel.buckneer.ui.signup

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentPersonalBinding

class PersonalFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPersonalBinding.inflate(inflater)

//        viewModel = ViewModelProviders.of(this).get(PersonalViewModel::class.java)

        binding.nextButtonToAccount.setOnClickListener {

            val fullName = binding.fullName.text.toString()
            val profession = binding.professionEditText.text.toString()
            val mobileNumber = binding.mobilePhoneEditText.text.toString()



            this.findNavController().navigate(PersonalFragmentDirections.actionPersonalFragmentToAccountFragment(
                fullName,
                profession,
                mobileNumber
            ))
        }

        return binding.root

    }

}
