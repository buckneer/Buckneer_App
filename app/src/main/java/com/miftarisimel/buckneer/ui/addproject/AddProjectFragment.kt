package com.miftarisimel.buckneer.ui.addproject

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentAddProjectBinding
import com.miftarisimel.buckneer.models.Category
import com.miftarisimel.buckneer.models.User
import com.miftarisimel.buckneer.ui.common.BaseFragment
import com.miftarisimel.buckneer.ui.common.setupAuthGuard

class AddProjectFragment : BaseFragment() {



    private lateinit var mViewModel: AddProjectViewModel
    private lateinit var mUser: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddProjectBinding.inflate(inflater)


        setupAuthGuard {
            mViewModel = initViewModel()
            binding.addProject.setOnClickListener {
                binding.share()
            }



            mViewModel.user.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.let {
                        mUser = it
                    }
                }
            })
        }

        mViewModel.shareCompletedEvent.observe(viewLifecycleOwner, Observer {
            this.findNavController().navigate(R.id.navigation_home)
        })

//        for (category in Category.values()) {
//            println(cardType.color)
//        }



        return binding.root
    }

    private fun FragmentAddProjectBinding.share() {
        val projectTitle = AddProjectFragmentArgs.fromBundle(arguments!!).projectTitle
        mViewModel.share(mUser, projectTitle, this.projectDescText.text.toString(), Category.ANDROID)
    }


}
