package com.example.smartmarket

import com.google.firebase.database.Exclude

data class Userdata(
    @get:Exclude
    val name:String?=null,
    val phone:String?=null,
    val email:String?=null)
