package com.example.xpandit.wppstatus.ui.adapter

import com.example.xpandit.wppstatus.data.model.ObStatus

class ReadStateAdapter(list: ArrayList<ObStatus>, private val onClick: (ObStatus)->Unit): BaseAdapter(list) {

    override fun createMessageSystem() {
        val status = getItem(0)
        //Create system message that is not new
        if (!status.ehSystem){
            addMessageSystem(ObStatus.createMessageSystem(false))
        }
    }

    override fun onClickItem(obStatus: ObStatus) {
        onClick(obStatus)
    }
}