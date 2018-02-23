package com.xbongbong.yapi.mongo

import com.xbongbong.yapi.dao.MongoUserDao
import com.xbongbong.yapi.entity.MongoUser
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner



/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 20:33
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class MongoUserTest {

    @Autowired
    val mongoUserDao: MongoUserDao ?= null

    @Test
    fun testSaveUser() {
        val user = MongoUser()
        user.firstName = "Hello 2"
        user.lastName = "World"
        user.testArray = arrayOf("789", "123")
        mongoUserDao!!.save(user)
    }

    @Test
    fun findUserByUserName() {
        val user = mongoUserDao!!.findByLastName("World")
        println("user is " + user)
    }

    @Test
    fun updateUser() {
        val user = MongoUser()
        user.id = 1L
        user.firstName = "Hello"
        user.lastName = "Kotlin"
        mongoUserDao!!.update(user)
    }

    @Test
    fun deleteUserById() {
        mongoUserDao!!.deleteById(1L)
    }

}