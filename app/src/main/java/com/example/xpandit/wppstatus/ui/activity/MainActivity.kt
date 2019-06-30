package com.example.xpandit.wppstatus.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.xpandit.wppstatus.R
import com.example.xpandit.wppstatus.data.dao.StatusDao
import com.example.xpandit.wppstatus.data.model.ObStatus
import com.example.xpandit.wppstatus.data.model.ObUser
import com.example.xpandit.wppstatus.ui.adapter.NewStateAdapter
import com.example.xpandit.wppstatus.ui.adapter.ReadStateAdapter
import com.example.xpandit.wppstatus.util.ImageUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.status_item.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapterNew: NewStateAdapter
    private lateinit var adapterRead: ReadStateAdapter

    private  var uri: String = ""

    private lateinit var dao: StatusDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myUser = ObUser.myUser()

        ImageUtil.mountsImage(item_image_status,myUser.image,this)
        item_title_status.text = "My State"
        item_subtitle_status.text = "Click to create a new status"
        item_status_divisor.visibility = View.GONE

        main_new_gallary.setOnClickListener {
            callLibGallary()
        }

        fab_main_camera.setOnClickListener {
            callCamera()
        }

        fab_main_text.setOnClickListener {
            callDialog()
        }
    }

    private fun callDialog() {

    }

    private fun callCamera() {

    }

    private fun callLibGallary() {

    }

    override fun onResume() {
        super.onResume()
        dao = StatusDao()
        adapterNew = NewStateAdapter(dao.searchNewStatus()){
            showStatus(it)
            dao.markSeen(it)
            updateScreen()
        }
        main_new_rec.adapter = adapterNew
        adapterRead = ReadStateAdapter(dao.searchReadStatus()){
            showStatus(it)
        }
        main_read_rec.adapter = adapterRead
    }

    private fun updateScreen() {
        adapterNew.notifyDataSetChanged()
        adapterRead.notifyDataSetChanged()
    }

    private fun showStatus(obStatus: ObStatus) {
       val  intent = Intent(this,VisualizationActivity::class.java)
        intent.putExtra(VisualizationActivity.STATUS,obStatus)
        startActivity(intent)
    }
}
