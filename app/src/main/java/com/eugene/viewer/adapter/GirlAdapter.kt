package com.eugene.viewer.adapter

import android.content.Context
import android.widget.TextView
import com.eugene.core.adapter.BaseAdapter
import com.eugene.core.adapter.BaseHolder
import com.eugene.viewer.R
import com.eugene.viewer.bean.Girl
import com.example.imageloader.ImageLoader
import com.example.imageloader.glide.GlideImageConfig

class GirlAdapter(context: Context, data: MutableList<Girl>)
    : BaseAdapter<Girl>(context, R.layout.item_girl, data) {

    override fun bindView(holder: BaseHolder, data: Girl, position: Int) {

        ImageLoader.loadImage(context, GlideImageConfig.build {
            imageView = holder.findView(R.id.iv_portrait)
            url = data.img
        })

        holder.findView<TextView>(R.id.tv_name).text = data.name
        holder.findView<TextView>(R.id.tv_age).text = data.age.toString()

    }

}