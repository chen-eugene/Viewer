package com.eugene.core.adapter

import android.support.v4.util.SparseArrayCompat

class ItemViewManger<T> {

    /**
     * viewType默认使用position
     */
    private val itemViews by lazy {
        SparseArrayCompat<MultiItemType<T>>()
    }

    fun addItemType(itemType: MultiItemType<T>) {
        val viewType = itemViews.size()
        itemViews.put(viewType, itemType)
    }

    fun addItemType(viewType: Int, itemType: MultiItemType<T>) {
        if (itemViews.valueAt(viewType) != null) {
            throw IllegalArgumentException("An ItemViewDelegate is already registered for the viewType = "
                    + viewType
                    + ". Already registered ItemViewDelegate is "
                    + itemViews.get(viewType))
        }
        itemViews.put(viewType, itemType)
    }

    /**
     * 遍历itemViews，根据传入的data来判断使用哪一个模板
     * itemView是只有一个对象，传入的data数据不同
     */
    fun getViewType(position: Int, data: T): Int {
        val count = itemViews.size()
        for (i in count downTo 0) {
            val item = itemViews.valueAt(i)
            if (item.isThisViewType(data, position)) {
                return itemViews.keyAt(i)
            }
        }
        throw IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position=$position in data source")
    }

    fun bindView(holder: BaseHolder, data: T, position: Int) {
        for (i in 0..itemViews.size()) {
            val itemView = itemViews.valueAt(i)
            if (itemView.isThisViewType(data, position)) {
                itemView.bindView(holder, data)
                return
            }
        }
    }

    /**
     * 是否是多视图
     */
    fun isMultiTypes(): Boolean {
        return itemViews.size() > 0
    }

    /**
     * 返回MultiItemType对象
     */
    fun getItem(viewType: Int): MultiItemType<T> {
        return itemViews.valueAt(viewType)
    }

}