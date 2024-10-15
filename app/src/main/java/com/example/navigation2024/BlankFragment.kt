package com.example.navigation2024

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


// Константы для аргументов
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentLayout = inflater.inflate(R.layout.fragment_blank, container, false)

        val navController = NavHostFragment.findNavController(this)

        fragmentLayout.findViewById<Button>(R.id.button2).setOnClickListener {
            navController.navigate(R.id.blankFragment2)
        }
        fragmentLayout.findViewById<Button>(R.id.button3).setOnClickListener {
            navController.navigate(R.id.blankFragment3)
        }
        fragmentLayout.findViewById<Button>(R.id.button4).setOnClickListener {
            navController.navigate(R.id.blankFragment4)
        }

        return fragmentLayout
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}