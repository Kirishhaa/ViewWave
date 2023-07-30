package com.example.sign_up_feature.presentation.singup

import android.os.Bundle
import android.view.View
import com.example.sign_up_feature.R
import com.example.sign_up_feature.databinding.FragmentSingUpBinding
import kirishhaa.viewwave.core.AbstractRegistrationFragment

class SingUpFragment: AbstractRegistrationFragment(R.layout.fragment_sing_up) {

    private lateinit var binding: FragmentSingUpBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingUpBinding.bind(view)

        binding.bSignUp.setOnClickListener {

        }
    }

}