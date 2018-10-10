package com.eugene.viewer.recyclerview.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.eugene.core.http.RetrofitManager
import com.eugene.core.utils.RxUtil
import com.eugene.viewer.R
import com.eugene.viewer.base.RetrofitApi

class HomePageActivity : AppCompatActivity() {

    private val homePageAdapter by lazy {
        //        HomePageAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        getHeaderData()

    }
    private fun getHeaderData() {

        RetrofitManager.obtainRetrofitService(RetrofitApi::class.java)
                .getHeader().compose(RxUtil.applySchedulers())
                .subscribe {
                    //                    throw NullPointerException("getHeaderData")
                }

        GridLayoutManager(this, 3).spanCount

    }


}