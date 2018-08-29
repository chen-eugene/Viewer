package com.eugene.core.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * 多类型adapter
 * 所有的item都使用相同的数据Entity,比如实现聊天界面
 */
abstract class MultiViewTypeAdapter<T>(val context: Context)
    : RecyclerView.Adapter<BaseHolder>() {

    private val itemViewManger by lazy {
        ItemViewManger<T>()
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemViewManger.isMultiTypes()) {
            super.getItemViewType(position)
        } else {
//            itemViewManger.getViewType(position, items[position])
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val itemType = itemViewManger.getItem(viewType)
        val layoutId = itemType.getLayoutId()
        return BaseHolder.getHolder(context, parent, layoutId)
    }

//    override fun bindView(holder: BaseHolder, data: T, position: Int) {
//        itemViewManger.bindView(holder, data, position)
//    }

    fun addMultiItemType(itemType: MultiItemType<T>) {
        itemViewManger.addItemType(itemType)
    }

}