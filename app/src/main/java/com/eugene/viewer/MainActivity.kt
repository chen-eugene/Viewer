package com.eugene.viewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.eugene.viewer.adapter.TabAdapter
import com.eugene.viewer.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initView() {
        val fragments = mutableListOf<Fragment>()

        fragments.add(RecyclerFragment.newInstance(this, null))
        fragments.add(OtherFragment.newInstance(this, null))

//        vp_content.adapter = TabAdapter(supportFragmentManager,)

    }


}
