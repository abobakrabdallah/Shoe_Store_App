package com.bakooor.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bakooor.shoeapp.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentInstructionsBinding.inflate(layoutInflater)
        binding.btnChooseTheShoe.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_listOfShoesFragment)
        }
        return binding.root
    }

}