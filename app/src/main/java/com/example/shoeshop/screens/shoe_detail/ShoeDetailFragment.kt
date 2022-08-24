package com.example.shoeshop.screens.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentShoeDetailBinding

import com.example.shoeshop.screens.shoe_listing.ShoeListingViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model =viewModel
        //save button
        binding.save.setOnClickListener {
            //check if fields is empty just don't do any thing and return
            if (binding.nameText.text.toString()
                    .isEmpty() || binding.companyText.text.toString()
                    .isEmpty() || binding.shoeSizeText.text.toString()
                    .isEmpty() || binding.descriptionText.text.toString().isEmpty()
            )
                return@setOnClickListener
            //if fields is not empty just parse the string value to double
            try {

                //add new item to listItem view model
                viewModel.updateList()
                //then navigate back
                this.findNavController().navigateUp()
            } catch (e: Exception) {
                //set error message if size have invalid char
                binding.shoeSize.error = "not valid value"
            }
        }
        //cancel button navigate to back
        binding.cancel.setOnClickListener { this.findNavController().navigateUp() }


    }


}