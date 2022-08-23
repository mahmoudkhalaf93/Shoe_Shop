package com.example.shoeshop.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        //observe on token if i have token then just go to welcome screen
        viewModel.haveToken.observe(viewLifecycleOwner) { haveToken ->
            if (haveToken)
                goToWelcomeScreen()
        }

        //login button check have method to check if edit text if  empty or not empty
        binding.login.setOnClickListener { validate() }
        //register button check have method to check if edit text if  empty or not empty
        binding.register.setOnClickListener { validate() }
    }



    private fun goToWelcomeScreen() {
        val navContoller: NavController = Navigation.findNavController(requireView())
        navContoller.navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

//validate method to check edit text of email and password
    fun validate() {

    //check if email is empty then set error message else clear old message if found
        if (binding.emailText.text.toString().isEmpty()) {
            binding.email.error = "empty"
        } else
            //for old error message to clear
            binding.email.error = ""

    //check if passowrd is empty then set error message else clear old message if found
        if (binding.passwordText.text.toString().isEmpty()) {
            binding.password.error = "empty"
        } else
        //for old error message to clear
            binding.password.error = ""

    //then final check if there is any field is empty just return and don't generate token
        if (binding.emailText.text.toString().isEmpty() || binding.passwordText.text.toString().isEmpty())
            return

        //just take the email and password and send them to server to generate token  then if server send back true just there is observe in
    // onViewCreated method to go to welcome screen
        viewModel.tokenGenerated(/*email , password*/)
    }

}