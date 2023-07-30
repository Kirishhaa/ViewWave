package kirishhaa.viewwave.sign_in_feature.presentation.singin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import dagger.hilt.android.AndroidEntryPoint
import kirishhaa.viewwave.core.AbstractRegistrationFragment
import kirishhaa.viewwave.core.IncorrectPasswordException
import kirishhaa.viewwave.core.IncorrectUsernameException
import kirishhaa.viewwave.sign_in_feature.R
import kirishhaa.viewwave.sign_in_feature.databinding.FragmentSingInBinding

@AndroidEntryPoint
class SignInFragment : AbstractRegistrationFragment(R.layout.fragment_sing_in) {

    private lateinit var binding: FragmentSingInBinding

    private val viewModel by viewModels<SignInViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingInBinding.bind(view)
        binding.bSignIn.setOnClickListener {
            val username = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.onSignInClicked(username, password)
        }

        binding.tvHaventAccount.setOnClickListener {
            viewModel.onHaventAccountClicked()
        }

        binding.tvForgetPasswordUsername.setOnClickListener {
            viewModel.onForgetPasswordUsernameClicked()
        }

        observeScreenState(binding.root, viewModel.state) { errorState ->
            when (errorState.error) {
                is IncorrectUsernameException -> {
                    binding.etEmail.error =
                        resources.getString(R.string.incorrect_email)
                }
                is IncorrectPasswordException -> {
                    binding.etPassword.error =
                        resources.getString(R.string.incorrect_password)
                }
                is FirebaseAuthInvalidUserException -> {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.invalid_user),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.incorrect_data),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}