package com.bakooor.shoeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bakooor.shoeapp.databinding.FragmentListOfShoesBinding
import com.bakooor.shoeapp.databinding.ItemShoeBinding

class ListOfShoesFragment : Fragment() {

    private lateinit var binding: FragmentListOfShoesBinding
    private val viewModel: ListOfShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfShoesBinding.inflate(inflater, container, false)

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listOfShoesFragment_to_shoeAttribuesFragment)
        }

        viewModel.list.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                list.forEach { item ->
                    addNewView(item, inflater, container)
                }
            }
        }

        return binding.root
    }

    private fun addNewView(item: Shoe, inflater: LayoutInflater, container: ViewGroup?) {
        val newItem: ItemShoeBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_shoe, container, false)
        newItem.name.text = item.name
        newItem.size.text = item.size.toString()
        newItem.company.text = item.company
        newItem.description.text = item.description
        binding.list.addView(newItem.root)
    }
}