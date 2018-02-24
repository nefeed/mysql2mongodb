package com.xbongbong.yapi.controller

import com.alibaba.fastjson.JSON
import com.xbongbong.yapi.entity.MySqlApiDoc
import com.xbongbong.yapi.pojo.CustomerResponseBody
import com.xbongbong.yapi.repository.InterfaceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 接口
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 16:38
 */
@RestController
@RequestMapping("/api/doc")
class ApiDocController @Autowired constructor(val interfaceRepository: InterfaceRepository) {
//    @Autowired constructor(val apiDocRepository: ApiDocRepository) {
//
//    @GetMapping("/")
//    fun findAll() = apiDocRepository.findAll()
//
//    @RequestMapping("/create", method = arrayOf(RequestMethod.POST))
//    @ResponseBody
//    fun create(@RequestBody mySqlApiDoc: MySqlApiDoc): MySqlApiDoc = apiDocRepository.save(mySqlApiDoc)
//
//    @GetMapping("/{name}")
//    fun findByName(@PathVariable name: String) = apiDocRepository.findByName(name)
//
//    @PutMapping("/update")
//    fun updateUser(@RequestBody mySqlApiDoc: MySqlApiDoc) {
//        apiDocRepository.save(mySqlApiDoc)
//    }
//
//    @DeleteMapping("/del/{id}")
//    @ResponseBody
//    fun deleteEmployee(@PathVariable id: Long) {
//        apiDocRepository.delete(id)
//    }

    @GetMapping("/transfer")
    @ResponseBody
    fun transfer(): CustomerResponseBody {
        val resource = ClassPathResource("api_doc.json")
        val br = BufferedReader(InputStreamReader(resource.inputStream))
        val content = br.readText()
        val json = JSON.parseObject(content)
        val listStr = json["list"].toString()
        val newList: List<MySqlApiDoc> = JSON.parseArray(listStr, MySqlApiDoc::class.java)

        for (it in newList) {
            interfaceRepository.transferApiDoc2Interface(it)
        }
        return CustomerResponseBody(0, "执行成功")
    }
}