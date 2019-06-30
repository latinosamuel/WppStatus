package com.example.xpandit.wppstatus.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.xpandit.wppstatus.R
import com.example.xpandit.wppstatus.data.model.ObStatus
import com.example.xpandit.wppstatus.util.ImageUtil
import kotlinx.android.synthetic.main.activity_visualization.*

class VisualizationActivity : AppCompatActivity() {

    companion object{
        const val STATUS = "STATUS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualization)

        if (intent.hasExtra(STATUS)){
            val obStatus = intent.getSerializableExtra(STATUS) as ObStatus
            if (obStatus.image.isEmpty() && obStatus.text.isNotEmpty()){
                image_visualization.visibility = View.GONE
                text_visualization.visibility = View.INVISIBLE
                text_visualization.text = obStatus.text
            }else{
                image_visualization.visibility = View.VISIBLE
                text_visualization.visibility = View.GONE
                ImageUtil.mountsImage(image_visualization,obStatus.image,this)
            }
        }
    }
}
