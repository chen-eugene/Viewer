package com.eugene.core.adapter

import android.content.Context
import android.view.ViewGroup

/**
 * 多类型adapter
 */
abstract class MultiItemAdapter<T>(context: Context, private val multiItemType: MultiItemType<T>)
    : BaseAdapter<T>(context, -1) {

    override fun getItemViewType(position: Int): Int {
        return multiItemType.getItemViewType(position, items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val layoutId = multiItemType.getLayoutId(viewType)
        return BaseHolder.getHolder(context, parent, layoutId)
    }

}