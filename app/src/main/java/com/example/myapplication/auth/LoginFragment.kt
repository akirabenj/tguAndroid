package com.example.myapplication.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.auth.controller.AuthController
import com.example.myapplication.auth.controller.IAuth

class LoginFragment : Fragment() {

    private var loginText: TextView? = null
    private var passwordText: TextView? = null
    private var loginButton: Button? = null
    private var registerButton: Button? = null
    private val authController = AuthController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        loginText = root.findViewById(R.id.loginText)
        passwordText = root.findViewById(R.id.passwordText)
        loginButton = root.findViewById(R.id.loginButton)
        registerButton = root.findViewById(R.id.registerButton)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        loginButton?.setOnClickListener {
            val infoArray = readInfo()
            if (authController.signIn(infoArray[0], infoArray[1])) {
                Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG)
            } else {
                Toast.makeText(requireContext(), "Fail", Toast.LENGTH_LONG)
            }
        }

        registerButton?.setOnClickListener {
            val navigationController = findNavController()
            navigationController.navigate(R.id.loginToRegister)
        }
    }

    private fun readInfo(): Array<String> {
        var infoArray = arrayOf("", "")
        infoArray[0] = loginText?.text.toString()
        infoArray[1] = passwordText?.text.toString()
        return infoArray
    }

}