package com.example.xpandit.wppstatus.data.model

import java.io.Serializable

class ObUser(val nome: String): Serializable {
    val image = "https//api.adorable.io/avatars/285/$nome.png"

    companion object{
        fun myUser() = ObUser("My Status")
    }

}
