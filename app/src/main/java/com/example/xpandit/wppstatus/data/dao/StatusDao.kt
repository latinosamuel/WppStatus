package com.example.xpandit.wppstatus.data.dao

import com.example.xpandit.wppstatus.data.model.ObStatus
import com.example.xpandit.wppstatus.data.model.ObUser

class StatusDao {

    companion object {
        private var id = 0
        get() {
            field++
            return field
        }

        private val newStatus = arrayListOf(
            ObStatus(id,true,false,"https://api.adorable.io/avatars/285/$id.png","", ObUser("user$id")),
            ObStatus(id,true,false,"","Example with text short", ObUser("user$id")),
            ObStatus(id,true,false,"https://api.adorable.io/avatars/285/23.png","",ObUser("user$id")),
            ObStatus(id,true,false,"https://api.adorable.io/avatars/285/597.png","",ObUser("user$id")),
            ObStatus(id,true,false,"","Example of long text to display on the preview screen", ObUser("user$id")),
            ObStatus(id,true,false,"https://api.adorable.io/avatars/285/06651.png","", ObUser("user$id"))
        )

        private val readStatus = ArrayList<ObStatus>()
    }

    fun searchNewStatus(): ArrayList<ObStatus>{
        newStatus.sortBy { obStatus -> obStatus.id }
        return newStatus
    }

    fun searchReadStatus(): ArrayList<ObStatus>{
        readStatus.sortBy { obStatus -> obStatus.id }
        return readStatus
    }

    //If found the object removes from the list and marks with seen
    fun markSeen(obStatus: ObStatus){
        val iterator = newStatus.iterator()
        while (iterator.hasNext()){
            val  st = iterator.next()
            if (st.id == obStatus.id){
                st.ehNew = false
                readStatus.add(st)
                iterator.remove()
                return
            }
        }
    }

    fun createStatusImage(uri: String){
        newStatus.add(ObStatus(StatusDao.id,true,false,uri,"",ObUser.myUser()))
    }

    fun createStatusText(text: String){
        newStatus.add(ObStatus(StatusDao.id,true,false,"",text, ObUser.myUser()))
    }
}