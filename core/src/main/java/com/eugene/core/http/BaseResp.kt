package com.eugene.core.http

data class BaseResp<T>(
        val status: Int,
        val data: T,
        val msg: String
)