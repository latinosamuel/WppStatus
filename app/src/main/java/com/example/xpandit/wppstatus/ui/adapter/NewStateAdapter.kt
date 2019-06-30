package com.example.xpandit.wppstatus.ui.adapter

import com.example.xpandit.wppstatus.data.model.ObStatus

class NewStateAdapter(list: ArrayList<ObStatus>,private val onClick: (ObStatus) -> Unit): BaseAdapter(list){
    override fun createMessageSystem() {
        val status = getItem(0)
        if (!status.ehSystem){
            addMessageSystem(ObStatus.createMessageSystem(true))
        }else{
            if (itemCount == 1)
                removeMessageSystem()
        }
    }

    override fun onClickItem(obStatus: ObStatus) {
        onClick(obStatus)
    }

}