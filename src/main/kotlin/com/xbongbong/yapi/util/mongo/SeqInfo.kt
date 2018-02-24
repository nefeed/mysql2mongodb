package com.xbongbong.yapi.util.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 14:40
 */
@Document(collection = "sequence")
data class SeqInfo(
        // 主键
        @Id
        val id: String,
        // 集合名称
        @Field
        val collName: String,
        // 序列值
        @Field
        val seqId: Int
)