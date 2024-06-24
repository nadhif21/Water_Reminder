package com.nadhif.waterreminder

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class UserViewModel : ViewModel() {
    var name = mutableStateOf("")
    var gender = mutableStateOf("")
    var age = mutableStateOf("")
    var weight = mutableStateOf("")

    fun updateUserData(name: String, gender: String, age: String, weight: String) {
        this.name.value = name
        this.gender.value = gender
        this.age.value = age
        this.weight.value = weight
    }
}
