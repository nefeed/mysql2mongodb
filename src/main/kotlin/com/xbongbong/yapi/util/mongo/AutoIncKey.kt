package com.xbongbong.yapi.util.mongo

/**
 * 自定义注解，标志组建字幕需要自增
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 14:29
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class AutoIncKey