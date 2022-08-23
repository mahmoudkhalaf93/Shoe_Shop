package com.example.shoeshop.screens.shoe_listing

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentShoeListingBinding
import com.example.shoeshop.databinding.LayoutShoeItemBinding


class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private val viewModel: ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoeList.observe(viewLifecycleOwner) { newItem ->
            // Log.i("ShoeListingFragment", "livedata: ")
            if (newItem.isNotEmpty()) {
                newItem.forEach { shoe ->
                    var itemBinding: LayoutShoeItemBinding =
                        LayoutShoeItemBinding.inflate(layoutInflater, binding.shoelist, false)
                    itemBinding.shoeItem = shoe
                    binding.shoelist.addView(itemBinding.root)

                }
            }

        }
        binding.addShoeButton.setOnClickListener {

            val navConrtroller = Navigation.findNavController(view)
            navConrtroller.navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }
    }



    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> loginScreen()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loginScreen() {
        val navController = this.findNavController()
        navController.navigate(R.id.action_shoeListingFragment_to_loginFragment)
    }


}