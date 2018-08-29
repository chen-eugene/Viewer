package com.eugene.core.http

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * 处理 Http 请求和响应结果的处理类
 */
interface HttpHandler {
    fun onHttpResultResponse(chain: Interceptor.Chain, response: Response): Response

    fun onHttpRequestBefore(chain: Interceptor.Chain, request: Request): Request

    companion object {

        //空实现
        val EMPTY: HttpHandler = object : HttpHandler {
            override fun onHttpResultResponse(chain: Interceptor.Chain, response: Response): Response {
                //不管是否处理,都必须将response返回出去
                return response
            }

            override fun onHttpRequestBefore(chain: Interceptor.Chain, request: Request): Request {
                //不管是否处理,都必须将request返回出去
                return request
            }
        }
    }

}
