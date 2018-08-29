package com.eugene.viewer.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    companion object {
        fun newInstance(context: Context, bundle: Bundle?): Fragment {
            return Fragment.instantiate(context, this::class.java.name, bundle)
        }
    }


}