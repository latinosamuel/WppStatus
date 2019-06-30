package com.example.xpandit.wppstatus.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.xpandit.wppstatus.R
import com.example.xpandit.wppstatus.data.model.ObStatus
import com.example.xpandit.wppstatus.data.model.ObStatus.Companion.createMessageSystem
import com.example.xpandit.wppstatus.util.ImageUtil
import kotlinx.android.synthetic.main.status_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseAdapter(private val stateList: ArrayList<ObStatus>): RecyclerView.Adapter<BaseAdapter.ViewHolder>() {

    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)


    init {
        if(stateList.isNotEmpty()){
            createMessageSystem()
        }
    }

    protected fun addMessageSystem(obStatus: ObStatus){
        stateList.add(0,obStatus)
    }

    protected fun removeMessageSystem(){
        stateList.removeAt(0)
    }

    abstract fun createMessageSystem()

    abstract fun onClickItem(obStatus: ObStatus)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)

        val view = if (viewType == ViewHolder.STATE_TYPE_SYSTEM)
            inflater.inflate(R.layout.system_item, viewGroup,false)
        else
            inflater.inflate(R.layout.status_item,viewGroup,false)

        val holder = ViewHolder(view, viewGroup.context)
        holder.title = view.findViewById(R.id.item_title_status)

        if (viewType == ViewHolder.PEOPLE_TYPE_STATE){
            holder.subtitle = view.findViewById(R.id.item_subtitle_status)
            holder.image = view.findViewById(R.id.item_image_status)

            holder.itemView.setOnClickListener {
                val tag = holder.itemView.tag
                if (tag != null){
                    onClickItem(tag as ObStatus)
                }
            }
        }
        return  holder
    }

    override fun getItemCount() = stateList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val status = getItem(position)
        holder.itemView.tag = status
        populateScreen(status,holder)
    }

    private fun populateScreen(status: ObStatus, holder: BaseAdapter.ViewHolder) {
        if (!status.ehSystem){
            holder.title!!.text = status.user.nome
            holder.subtitle!!.text = sdf.format(status.data)
            ImageUtil.mountsImage(holder.image!!,status.user.image,holder.context)
        }else{
            holder.title!!.text = status.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        val status = getItem(position)

        if (status.ehSystem)
            return ViewHolder.STATE_TYPE_SYSTEM

        return ViewHolder.PEOPLE_TYPE_STATE
    }

    protected fun getItem(position: Int): ObStatus {
        return stateList[position]
    }

    class ViewHolder(itemView: View, var context: Context): RecyclerView.ViewHolder(itemView){
        companion object {
            const val STATE_TYPE_SYSTEM = 10
            const val PEOPLE_TYPE_STATE = 20
        }

        var title: TextView? = null
        var subtitle: TextView? = null
        var image: ImageView? = null
    }
}