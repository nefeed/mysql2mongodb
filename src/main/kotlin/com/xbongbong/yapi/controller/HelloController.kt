package com.xbongbong.yapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 欢迎页Controller
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 16:14
 */
@RestController
class HelloController {
    @GetMapping("/hello")
    fun sayHello() = "Hello Wolrd"
}