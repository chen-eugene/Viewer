package com.eugene.viewer.recyclerview

import com.eugene.core.adapter.BaseHolder
import com.eugene.core.adapter.MultiItemType
import com.eugene.viewer.R
import com.eugene.viewer.bean.HomePageEntity

class HeaderItemType : MultiItemType<HomePageEntity> {
    override fun getLayoutId(): Int {
        return R.layout.item_home_page_header
    }

    override fun isThisViewType(data: HomePageEntity, position: Int): Boolean {
        return true
    }

    override fun bindView(holder: BaseHolder, data: HomePageEntity) {

    }
}