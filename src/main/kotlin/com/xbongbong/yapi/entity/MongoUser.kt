package com.xbongbong.yapi.entity

import com.xbongbong.yapi.util.mongo.AutoIncKey
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

/**
 * Mongo数据库的User实体
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 20:25
 */
@Document(collection = "mongo_user")
data class MongoUser (
        @AutoIncKey
        @Id
        var id: Int ?= null,

        @Field("first_name")
        var firstName: String = "",
        @Field(value = "last_name")
        var lastName: String = "",
        @Field("test_array")
        var testArray: Array<String> = arrayOf("123", "456")
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as MongoUser

                if (id != other.id) return false
                if (firstName != other.firstName) return false
                if (lastName != other.lastName) return false
                if (!Arrays.equals(testArray, other.testArray)) return false

                return true
        }

        override fun hashCode(): Int {
                var result = if(id == null) 0 else id!!.hashCode()
                result = 31 * result + firstName.hashCode()
                result = 31 * result + lastName.hashCode()
                result = 31 * result + Arrays.hashCode(testArray)
                return result
        }
}