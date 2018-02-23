package com.xbongbong.yapi.pojo.yapi

import org.bson.types.ObjectId

/**
 * 请求参数的form实体
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 16:46
 */
data class ReqBodyFormPojo(
        // 是否必填，1/0
        var required: String = "1",
        // 特殊的id
        var _id: ObjectId = ObjectId.get(),
        // 描述
        var desc: String = "",
        // 示例
        var example: String = "",
        // 类型，text或file
        var type: String = "text",
        // 参数名称
        var name: String = ""
)