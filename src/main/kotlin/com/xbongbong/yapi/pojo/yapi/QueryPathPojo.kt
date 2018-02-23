package com.xbongbong.yapi.pojo.yapi

/**
 * 请求路径，Get形式使用
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 17:16
 */
data class QueryPathPojo (
        var path: String = "/",
        var params: Array<String> = emptyArray()
)