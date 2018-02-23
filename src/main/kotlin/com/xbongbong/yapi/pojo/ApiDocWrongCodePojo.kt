package com.xbongbong.yapi.pojo

/**
 * API错误码实体类
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 17:56
 */
data class ApiDocWrongCodePojo (
        // 错误码
        var code: String = "",
        // 错误说明
        var msg: String = ""
)