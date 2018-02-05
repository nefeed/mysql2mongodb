package com.xbongbong.yapi.entity

/**
 * Mongo数据库的User实体
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 20:25
 */
data class MongoUser (
        var id: Long = 0,

        var firstName: String = "",
        var lastName: String = ""
)