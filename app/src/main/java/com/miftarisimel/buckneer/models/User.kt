package com.miftarisimel.buckneer.models

data class User(
    var uid: String = "",
    var name: String = "", //Personal info
    var username: String = "", //Account info
    var email: String = "", //account info
    var profession: String = "", //Personal info
    var accountType: String = "1", // By default
    var mobileNumber: String = "" // personal info

    //Password to account info
)