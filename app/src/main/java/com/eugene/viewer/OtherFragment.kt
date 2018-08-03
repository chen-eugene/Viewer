package com.eugene.viewer

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.viewer.base.BaseFragment

class OtherFragment:BaseFragment() {

    companion object {
        fun newInstance(context: Context, bundle: Bundle?): Fragment {
            return Fragment.instantiate(context, this::class.java.name, bundle)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_other,container)
    }

}