package com.eugene.core.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment

inline fun <reified T> Activity.launchActivity(bundle: Bundle?) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtra("bundle", bundle)
    }
    startActivity(intent)
}

inline fun <reified T> Fragment.launchActivity(bundle: Bundle?) {
    val intent = Intent(this.activity, T::class.java)
    if (bundle != null) {
        intent.putExtra("bundle", bundle)
    }
    startActivity(intent)
}