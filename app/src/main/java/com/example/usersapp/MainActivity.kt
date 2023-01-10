package com.example.usersapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val container = this.findViewById<FragmentContainerView>(R.id.container)
        supportFragmentManager.beginTransaction()
            .replace(container.id, MyUsersFragment())
            .addToBackStack(null)
            .commit()
    }
}