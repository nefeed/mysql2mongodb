package com.xbongbong.yapi.mongo

import com.xbongbong.yapi.dao.MongoInterfaceDao
import com.xbongbong.yapi.entity.yapi.MongoInterface
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-24 10:03
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class MongoInterfaceTest {

    @Autowired
    val mongoInterfaceDao: MongoInterfaceDao? = null

    @Test
    fun createTest() {
        val it = MongoInterface()
        it.title = "测试接口"
        mongoInterfaceDao!!.save(it)
    }
}