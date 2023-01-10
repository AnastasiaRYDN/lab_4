package com.example.usersapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyUsersRepository {

    private var myUsers = mutableListOf<User>()
    private var myUsersLiveData = MutableLiveData<List<User>>()
    private var myIncrementer = 0

    init {
        for (i in 0 until 50) {
            addUser(
                User(
                    id = myIncrementer,
                    name = if (myIncrementer % 2 == 0) "Bob $i" else "Kesha $i",
                    secondName = if (myIncrementer % 2 == 0) "Bobinsky $i" else "Stevenson $i"
                )
            )
        }
    }

    private fun updateElements() {
        myUsersLiveData.value = myUsers.toList()
    }

    private fun addUser(user: User) {
        myUsers.add(element = user)
        myIncrementer++
        updateElements()
    }

    fun removeUser(user: User) {
        myUsers.remove(user)
        updateElements()
    }

    fun getUsers(): LiveData<List<User>> = myUsersLiveData

    fun addNewUser(name: String, surname: String) {
        addUser(
            User(
                myIncrementer,
                name,
                surname
            )
        )
    }

}