package com.xbongbong.yapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.xbongbong"])
class YapiApplication

fun main(args: Array<String>) {
    SpringApplication.run(YapiApplication::class.java, *args)
}
