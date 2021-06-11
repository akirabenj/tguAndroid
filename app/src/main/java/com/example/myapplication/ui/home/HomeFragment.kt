package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private var button: Button? = null
    private var editText: TextView? = null
    private var listView: ListView? = null
    private var productList = arrayListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.button2)
        editText = view.findViewById(R.id.productText)
        listView = view.findViewById(R.id.productList)
        adapter = ArrayAdapter(requireContext(), R.layout.list_item, productList)
        listView?.adapter = adapter

        button?.setOnClickListener {
            addProduct()
        }
    }

    private fun addProduct() {
        val product = editText?.text.toString()
        productList.add(product)
        adapter.notifyDataSetChanged()
    }
}