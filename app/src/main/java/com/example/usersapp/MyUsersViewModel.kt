package com.example.usersapp

import androidx.lifecycle.ViewModel

class MyUsersViewModel : ViewModel() {

    private val myRepository = MyUsersRepository()

    val myUsers = myRepository.getUsers()

    fun removeUser(user: User) = myRepository.removeUser(user)

    fun addUser(name: String, surname: String) {
        myRepository.addNewUser(name, surname)
    }

}