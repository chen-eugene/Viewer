package com.eugene.viewer.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.eugene.viewer.R
import com.eugene.viewer.bean.Girl
import com.example.imageloader.ImageLoader
import com.example.imageloader.glide.GlideImageConfig

class ListViewAdapter(private val context: Context, private val data: MutableList<Girl>)
    : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convert = convertView
        var holder: Holder? = null
        if (convertView == null) {
            holder = Holder()
            convert = View.inflate(context, R.layout.item_girl, null)
            holder.ivPortrait = convert?.findViewById(R.id.iv_portrait)
            holder.tvName = convert?.findViewById(R.id.tv_name)
            holder.tvAge = convert?.findViewById(R.id.tv_age)
            convert?.tag = holder

        } else {
            holder = convert?.tag as Holder
        }
        ImageLoader.loadImage(context, GlideImageConfig.build {
            imageView = holder.ivPortrait
            url = data[position].img
        })


        holder.tvName?.text = data[position].name
        holder.tvAge?.text = data[position].age.toString()

        return convert!!
    }

    private class Holder {

        var ivPortrait: ImageView? = null
        var tvName: TextView? = null
        var tvAge: TextView? = null

    }

}