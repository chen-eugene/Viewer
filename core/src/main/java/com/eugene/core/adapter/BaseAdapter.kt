package com.eugene.core.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.core.utils.RxView

abstract class BaseAdapter<T>(val context: Context, private val layoutId: Int) : RecyclerView.Adapter<BaseHolder>() {

    var items: MutableList<T> = mutableListOf()

    constructor(context: Context, layoutId: Int, data: MutableList<T>) : this(context, layoutId) {
        this.items = data
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view = LayoutInflater.from(context).inflate(layoutId, parent, false)
        return BaseHolder(view)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        RxView.clicks(holder.itemView).subscribe {
            onItemClick(holder.itemView, position)
        }
        bindView(holder, items[position], position)
    }

    abstract fun bindView(holder: BaseHolder, data: T, position: Int)

    override fun getItemCount(): Int = items.size

    open fun onItemClick(parent: View, position: Int) {}

    fun insertItem(item: T, position: Int) {
        items.add(position, item)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, items.size)
    }

    fun insertItems(data: List<T>) {
        val position = items.size
        items.addAll(data)
        notifyItemRangeInserted(position, items.size)
    }

    fun setDatas(data: List<T>) {
        items = data.toMutableList()
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }
}