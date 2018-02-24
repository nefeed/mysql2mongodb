package com.xbongbong.yapi.entity

import java.util.*

/**
 * Api文档
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 17:45
 */
//@Entity
//@Table(name = "tb_api_doc")
data class MySqlApiDoc(
        //Api Doc 主键
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        //Api Doc 版本号
        var version: String? = "",
        //Api Doc 模块名
        var module: String? = "",
        //Api Doc 接口名
        var name: String? = "",
        //Api Doc 请求地址，不包含域名部分
        var url: String? = "",
        //Api Doc 创建者名称
        var username: String? = "",
        //Api Doc 请求方式：POST或GET
        var method: String? = "",
        //Api Doc 说明
        var memo: String? = "",
        //Api Doc 请求参数 {"key": "参数 key", "name": "参数中文", "type": "参数类型（String、int、float、double、boolean）", "limie": "参数长度上限（0：无上限）", "required": "是否必填（boolean）", "memo": "说明"}
        var params: String? = "",
        //Api Doc 请求参数 Demo
        var paramsDemo: String? = "",
        //Api Doc 返回 Response 的 body 主要内容 {"key": "参数 key", "name": "参数中文", "type": "参数类型（String、int、float、double、boolean）", "memo": "说明"}
        var response: String? = "",
        //Api Doc 返回 Response 的 body 的 demo
        var responseDemo: String? = "",
        //错误代码： {"code": "错误代码 Code", "msg": "错误说明"}
        var wrongCode: String? = "",
        //创建时间（Unix_timestamp）
        var addTime: Int? = (Date().time / 1000L).toInt(),
        //更新时间（Unix_timestamp）
        var updateTime: Int? = (Date().time / 1000L).toInt(),
        //是否删除
        var del: Int? = 0
) {
    override fun toString(): String {
        return "MySqlApiDoc(id=$id, version='$version', module='$module', name='$name', url='$url', username='$username', method='$method', memo='$memo', params='$params', paramsDemo='$paramsDemo', response='$response', responseDemo='$responseDemo', wrongCode='$wrongCode', addTime=$addTime, updateTime=$updateTime, del=$del)"
    }
}