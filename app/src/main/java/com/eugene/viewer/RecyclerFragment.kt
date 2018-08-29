package com.eugene.viewer

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.core.utils.RxView
import com.eugene.core.utils.launchActivity
import com.eugene.viewer.base.BaseFragment
import com.eugene.viewer.recyclerview.HomePageActivity
import kotlinx.android.synthetic.main.fragment_recycler.*

class RecyclerFragment : BaseFragment() {

    companion object {
        fun newInstance(context: Context, bundle: Bundle?): Fragment {
            return Fragment.instantiate(context, RecyclerFragment::class.java.name, bundle)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxView.clicks(btn_home_page).subscribe {
            launchActivity<HomePageActivity>(null)
        }


    }


}