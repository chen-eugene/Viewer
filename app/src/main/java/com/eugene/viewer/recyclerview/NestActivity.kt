package com.eugene.viewer.recyclerview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.eugene.viewer.OtherFragment
import com.eugene.viewer.R
import com.eugene.viewer.adapter.TabAdapter
import com.eugene.viewer.recyclerview.fragment.ScrollListViewFragment
import com.eugene.viewer.recyclerview.fragment.ScrollRecyclerFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  ScrollView RecyclerView ViewPager嵌套问题
 */
class NestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nest)

        initView()

    }

    private fun initView() {
        val fragments = mutableListOf<Fragment>()

        fragments.add(ScrollListViewFragment.newInstance(this, null))
        fragments.add(ScrollRecyclerFragment.newInstance(this, null))
        fragments.add(OtherFragment.newInstance(this, null))

        val titles = mutableListOf<String>().apply {
            add("ListView")
            add("RecyclerView")
            add("Other")
        }

        vp_content.adapter = TabAdapter(supportFragmentManager, fragments, titles)
        tl_nav?.setupWithViewPager(vp_content)

    }


}