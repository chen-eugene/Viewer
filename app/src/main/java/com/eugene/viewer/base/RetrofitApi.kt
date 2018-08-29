package com.eugene.viewer.base

import com.eugene.viewer.bean.HeaderEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface RetrofitApi {

    @GET("http://112.124.22.238:8081/course_api/banner/query?type=1")
    fun getHeader(): Observable<List<HeaderEntity>>

}