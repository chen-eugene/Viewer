package com.eugene.core.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.Observer

object RxView {

    fun clicks(view: View?): Observable<String> {
        return ViewClickObservable(view)
    }

    fun textChange(view: TextView?): Observable<String> {
        return TextChangeObservable(view)
    }


    class ViewClickObservable(val view: View?) : Observable<String>() {

        override fun subscribeActual(observer: Observer<in String>?) {
            view?.setOnClickListener {
                observer?.onNext("onClick")
            }
        }

    }

    class TextChangeObservable(val view: TextView?) : Observable<String>() {


        override fun subscribeActual(observer: Observer<in String>?) {
            view?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    observer?.onNext(s.toString())
                }

            })
        }


    }

}