package com.eugene.core.adapter

interface MultiItemType<T> {

    /**
     * 根据type返回不同的布局
     */
    fun getLayoutId(): Int

    /**
     * 根据传入的数据类来判断使用哪一个模板
     * 是否使用多种布局模式
     */
    fun isThisViewType(data: T, position: Int): Boolean

    fun bindView(holder: BaseHolder, data: T)

}