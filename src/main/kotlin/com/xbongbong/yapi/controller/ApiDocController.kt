package com.xbongbong.yapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 接口
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 16:38
 */
@RestController
@RequestMapping("/api/doc")
class ApiDocController {
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
}