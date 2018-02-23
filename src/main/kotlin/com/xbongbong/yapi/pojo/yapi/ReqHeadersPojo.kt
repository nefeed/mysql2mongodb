package com.xbongbong.yapi.pojo.yapi

import org.bson.types.ObjectId

/**
 * 请求参数的Header实体
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 16:46
 */
data class ReqHeadersPojo(
        // 是否必填，1/0
        var required: String = "1",
        // 特殊的id
        var _id: ObjectId = ObjectId.get(),
        var value: String = "application/x-www-form-urlencoded",
        var name: String = "Content-Type"
)