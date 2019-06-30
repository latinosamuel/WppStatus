package com.example.xpandit.wppstatus.data.model

import java.io.Serializable
import java.util.*

class ObStatus (
    var id: Int,
    var ehNew: Boolean,
    var ehSystem: Boolean,
    var image: String,
    var text: String,
    val user: ObUser
): Serializable {
    var data: Date? = null

    init {
        val cal = Calendar.getInstance()
        data = cal.time
    }

    companion object {
        fun createMessageSystem(ehNew: Boolean): ObStatus{
            if (ehNew)
                return ObStatus(0,true,true,"","New Status", ObUser(""))

            return ObStatus(0,false,true,"","View Status",ObUser(""))
        }
    }
}