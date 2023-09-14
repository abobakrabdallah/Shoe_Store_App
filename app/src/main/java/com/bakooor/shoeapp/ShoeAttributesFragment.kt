package com.bakooor.shoeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bakooor.shoeapp.databinding.FragmentShoeAttribuesBinding

class ShoeAttributesFragment : Fragment() {

    private lateinit var binding: FragmentShoeAttribuesBinding
    private val viewModel: ListOfShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeAttribuesBinding.inflate(layoutInflater)

        dummyData()

        binding.btnAddShoe.setOnClickListener {
            val nameOfShoe = binding.edShoeName.text.toString()
            val nameOfCompany = binding.edCompany.text.toString()
            val sizeOfShoe = binding.edSize.text.toString()
            val description = binding.etDescription.text.toString()

            if (nameOfShoe != "" && nameOfCompany != "" && sizeOfShoe != "" && description != "") {
                viewModel.addShoe(nameOfShoe, nameOfCompany, sizeOfShoe.toInt(), description)
                findNavController().navigateUp()
            }
        }

        binding.btnCancel.setOnClickListener { findNavController().navigateUp() }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun dummyData() {
        binding.edShoeName.setText("edfgerd")
        binding.edSize.setText("12")
        binding.edCompany.setText("grehtttyuy")
        binding.etDescription.setText("sdfghjkl0liuygfhjbkl;  dtygukhkn 'lkjhgfdghjk")
    }
}