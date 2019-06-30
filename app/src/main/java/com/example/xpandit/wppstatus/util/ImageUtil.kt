package com.example.xpandit.wppstatus.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

//All methods are static
object ImageUtil {
    fun mountsImage(imageView: ImageView,link: String,context: Context){
        if (link.startsWith("http")){
            Glide.with(context).load(link).into(imageView)
        }else{
            Glide.with(context).load(File(link)).into(imageView)
        }
    }
}
