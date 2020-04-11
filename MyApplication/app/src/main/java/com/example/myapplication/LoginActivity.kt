package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.data.DataManager

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val errorMessage = findViewById<TextView>(R.id.errorMessage)
        errorMessage.visibility = View.INVISIBLE
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener(){
           val verify =  DataManager.verifyUser(username.toString(),password.toString())
            if(!verify){
                errorMessage.text = "Wrong username or password, please try again."
                errorMessage.visibility = View.VISIBLE
                username.text = "Username"
                password.text = "Password"
            }
        }

    }
}
