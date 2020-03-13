package com.miftarisimel.buckneer.ui.login

import android.animation.ValueAnimator
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentLoginBinding
import com.miftarisimel.buckneer.ui.common.BaseFragment

class LoginFragment : BaseFragment() {



    private lateinit var mViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentLoginBinding.inflate(inflater)

        mViewModel = initViewModel()


        mViewModel.goToHomeScreen.observe(viewLifecycleOwner, Observer {
            this.findNavController().navigate(R.id.navigation_home)
        })

        binding.nextButton.setOnClickListener {
            val animator = ValueAnimator.ofFloat(0f, 1f)
            animator.addUpdateListener { animation ->
                binding.logoColored.alpha = animation.animatedValue as Float
            }
            animator.duration = 500
//            animator.repeatMode = ValueAnimator.REVERSE;
//            animator.repeatCount = -1;
            animator.start()

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            mViewModel.onLogin(email, password)

        }

        binding.signupText.setOnClickListener {
            this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToPersonalFragment())
        }


        return binding.root
    }


}
