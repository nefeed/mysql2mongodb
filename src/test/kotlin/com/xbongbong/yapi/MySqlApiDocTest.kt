package com.xbongbong.yapi

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.xbongbong.yapi.entity.MySqlApiDoc
import com.xbongbong.yapi.repository.InterfaceRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.junit4.SpringRunner
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-24 10:03
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class MySqlApiDocTest {

//    @Autowired
//    val apiDocRepository: ApiDocRepository? = null
//
//    @Test
//    fun listTest() {
//        println(apiDocRepository!!.findAll().toString())
//    }

    @Autowired
    val interfaceRepository: InterfaceRepository? = null

    @Test
    fun readJsonFile() {
        val resource = ClassPathResource("api_doc.json")
        val br = BufferedReader(InputStreamReader(resource.inputStream))
        val content = br.readText()
//        println("Content:$content")
        val json = JSON.parseObject(content)
        val listStr = json["list"].toString()
//        println("list String:$listStr")
        val array: JSONArray = JSON.parseArray(listStr)
//        val list: List<MySqlApiDoc> = JSON.parseArray(listStr, MySqlApiDoc::class.java)
        println("list length:${array.size}")
        val list: Array<MySqlApiDoc> = Array(array.size, {MySqlApiDoc()})
        array.map { it ->
                    JSON.parseObject(it.toString(), MySqlApiDoc::class.java)
//            println("item:$item")
                }
                .forEachIndexed { index, it ->
                    list[index] = it
                }
        println("plus list Length:${list.size}")
        val newList: List<MySqlApiDoc> = JSON.parseArray(listStr, MySqlApiDoc::class.java)
        println("mew list length:${newList.size}")

        for (it in newList) {
            interfaceRepository!!.transferApiDoc2Interface(it)
        }
    }
}