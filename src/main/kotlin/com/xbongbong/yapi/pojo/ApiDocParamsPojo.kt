package com.xbongbong.yapi.pojo

/**
 * api文档参数
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 17:59
 */
data class ApiDocParamsPojo (
        var key: String = "",
        var name: String = "",
        var type: String = "",
        var limit: Int = 0,
        var required: Boolean = false,
        var memo: String = ""
)