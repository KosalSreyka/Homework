package com.example.homework

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.room.util.copy

class RegisterViewModel:ViewModel() {
     var register= mutableStateOf(Register())
    fun nameChange(name:String)
    {
        register.value=register.value.copy(name=name)
    }
    fun genderChange(gender:String)
    {
        register.value=register.value.copy(gender=gender)

    }
    fun phoneChange(phone:String)
    {
        register.value=register.value.copy(phone=phone)
    }
    fun addressChange(add:String)
    {
        register.value=register.value.copy(address = add)
    }
}