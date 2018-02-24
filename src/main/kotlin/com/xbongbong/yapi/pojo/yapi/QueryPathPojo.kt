package com.xbongbong.yapi.pojo.yapi

import java.util.*

/**
 * 请求路径，Get形式使用
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 17:16
 */
data class QueryPathPojo (
        var path: String = "/",
        var params: Array<String> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as QueryPathPojo

        if (path != other.path) return false
        if (!Arrays.equals(params, other.params)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = path.hashCode()
        result = 31 * result + Arrays.hashCode(params)
        return result
    }
}