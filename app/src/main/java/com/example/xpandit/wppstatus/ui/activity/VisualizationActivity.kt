package com.example.xpandit.wppstatus.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.xpandit.wppstatus.R

class VisualizationActivity : AppCompatActivity() {

    companion object{
        const val STATUS = "STATUS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualization)
    }
}
