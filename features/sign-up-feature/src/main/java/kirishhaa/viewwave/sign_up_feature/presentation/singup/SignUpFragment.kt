package kirishhaa.viewwave.sign_up_feature.presentation.singup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.sign_up_feature.R
import com.example.sign_up_feature.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.core.AbstractRegistrationFragment
import kirishhaa.viewwave.core.IncorrectEmailException
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.core.PasswordsMatchException
import kirishhaa.viewwave.core.R.string.*

@AndroidEntryPoint
class SignUpFragment: AbstractRegistrationFragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        binding.bSignUp.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val repeatedPassword = binding.etRepeatPassword.text.toString()
            viewModel.onCreateAccountClicked(email, password, repeatedPassword)
        }

        observeScreenState(binding.root, viewModel.state) { errorState ->
            when(errorState.error) {
                is IncorrectEmailException -> {
                    binding.etEmail.error = resources.getString(incorrect_email)
                }
                is IncorrectPasswordException -> {
                    binding.etPassword.error = resources.getString(incorrect_password)
                }
                is PasswordsMatchException -> {
                    binding.etRepeatPassword.error = resources.getString(incorrect_repeated_password)
                }
                else -> {
                    Toast.makeText(context, resources.getString(incorrect_data), Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

}