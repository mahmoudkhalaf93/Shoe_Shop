package com.example.shoeshop.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {


    private lateinit var viewModel: InstructionsViewModel
    private lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //unused View Model
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        //go to shoes list screen
        binding.shopingButton.setOnClickListener { v ->
            val navConrtroller = Navigation.findNavController(v)
            navConrtroller.navigate(R.id.action_instructionsFragment_to_shoeListingFragment)
        }
    }
}