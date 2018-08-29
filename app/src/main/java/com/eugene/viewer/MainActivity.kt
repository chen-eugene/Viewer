package com.eugene.viewer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.eugene.viewer.adapter.TabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val fragments = mutableListOf<Fragment>()

        fragments.add(RecyclerFragment.newInstance(this, null))
        fragments.add(OtherFragment.newInstance(this, null))

        val titles = mutableListOf<String>().apply {
            add("Recycler")
            add("Other")
        }

        vp_content.adapter = TabAdapter(supportFragmentManager, fragments, titles)
        tl_nav?.setupWithViewPager(vp_content)

    }

    private fun setCustomDensity() {
        val displayMetrics = applicationContext.resources.displayMetrics
        val targetDensity = displayMetrics.widthPixels / 360
        val targetDensityDpi = targetDensity * 160

        //density缩放多少，scaledDensity就缩放多少
        displayMetrics.scaledDensity = displayMetrics.scaledDensity / displayMetrics.density * targetDensity
        displayMetrics.density = targetDensity.toFloat()
        displayMetrics.densityDpi = targetDensityDpi

        val activityDisplayMetrics = this.resources.displayMetrics
        val activityTargetDensity = displayMetrics.widthPixels / 360
        val activityTargetDensityDpi = targetDensity * 160

        //density缩放多少，scaledDensity就缩放多少
        activityDisplayMetrics.scaledDensity = activityDisplayMetrics.scaledDensity / activityDisplayMetrics.density * activityTargetDensity
        activityDisplayMetrics.density = activityTargetDensity.toFloat()
        activityDisplayMetrics.densityDpi = activityTargetDensityDpi


    }


}
