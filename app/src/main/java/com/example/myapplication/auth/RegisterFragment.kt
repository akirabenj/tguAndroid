package com.example.myapplication.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.auth.controller.AuthController

class RegisterFragment : Fragment() {

    private var loginTextView: TextView? = null
    private var passTextView: TextView? = null
    private var registerButton: Button? = null
    private var authController: AuthController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_register, container, false)
        // Inflate the layout for this fragment
        authController = AuthController()
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginTextView = view.findViewById(R.id.loginText1)
        passTextView = view.findViewById(R.id.passwordText1)
        registerButton = view.findViewById(R.id.registerButton1)

        registerButton?.setOnClickListener {
            val userInfo = readInfo()
            if (authController!!.signUp(userInfo[0], userInfo[1])) {
                Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Not valid", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun readInfo(): Array<String> {
        var infoArray = arrayOf("", "")
        infoArray[0] = loginTextView?.text.toString()
        infoArray[1] = passTextView?.text.toString()
        return infoArray
    }
}