package com.eugene.core.adapter

interface MultiItemType<T> {

    /**
     * 根据type返回不同的布局
     */
    fun getLayoutId(itemType: Int): Int

    /**
     * 返回视图类型
     */
    fun getItemViewType(position: Int, t: T): Int

}