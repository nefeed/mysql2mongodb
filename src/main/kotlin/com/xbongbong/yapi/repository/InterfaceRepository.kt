package com.xbongbong.yapi.repository

import com.alibaba.fastjson.JSON
import com.xbongbong.yapi.dao.MongoInterfaceDao
import com.xbongbong.yapi.entity.MySqlApiDoc
import com.xbongbong.yapi.entity.yapi.MongoInterface
import com.xbongbong.yapi.pojo.ApiDocParamsPojo
import com.xbongbong.yapi.pojo.ApiDocResponsePojo
import com.xbongbong.yapi.pojo.yapi.QueryPathPojo
import com.xbongbong.yapi.pojo.yapi.ReqBodyFormPojo
import com.xbongbong.yapi.pojo.yapi.ReqHeadersPojo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * yapi接口的处理类
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-24 14:21
 */
@Service
class InterfaceRepository @Autowired constructor(val mongoInterfaceDao: MongoInterfaceDao) {
    /**
     * 将本地的api文档转译为yapi所需的格式
     */
    fun transferApiDoc2Interface(apiDoc: MySqlApiDoc): MongoInterface {
        val mongoInterface = MongoInterface()
        mongoInterface.catId = getCatId(apiDoc.module)
        mongoInterface.title = apiDoc.name.toString()
        mongoInterface.path = apiDoc.url.toString()
        if (apiDoc.addTime != null) {
            mongoInterface.addTime = apiDoc.addTime!!
        }
        if (apiDoc.updateTime != null) {
            mongoInterface.upTime = apiDoc.updateTime!!
        }
        if (!apiDoc.params.isNullOrEmpty()) {
            mongoInterface.reqBodyForm = formatReqBodyForm(apiDoc.params!!)
        }
        mongoInterface.queryPath = QueryPathPojo(path = apiDoc.url.toString())
        mongoInterface.reqHeaders = arrayOf(ReqHeadersPojo())
        // 已完成
        mongoInterface.status = "done"
        // TODO 将返回参数描述放进来
        mongoInterface.desc = "<p>${apiDoc.memo}<br >${formatResponseBody(apiDoc.response)}</p>"
        mongoInterface.resBody = apiDoc.responseDemo.toString()
//        println("接口id(${apiDoc.id})的模块(${apiDoc.module})对应catid：${mongoInterface.catId}")
        mongoInterfaceDao.save(mongoInterface)
        return mongoInterface
    }

    /**
     * 根据模块名获得分类id
     */
    fun getCatId(moduleName: String?): Int {
        return when(moduleName) {
            "话务中心" -> 13
            "客户模块" -> 21
            "销售机会模块" -> 29
            "合同模块" -> 37
            "访客计划模块" -> 45
            "跟进记录模块" -> 53
            "消息模块" -> 413
            "SFA模块" -> 61
            "BI智能报表模块" -> 69
            "审批模块" -> 77
            "发票模块" -> 85
            "产品模块" -> 133
            "用户模块" -> 101
            "公司配置" -> 109
            "短信模块" -> 117
            "出库单模块" -> 125
            "jxc模块" -> 133
            "入库单模块" -> 141
            "回款模块" -> 149
            "采购合同模块" -> 157
            "采购退货单模块" -> 165
            "盘点单模块" -> 173
            "调拨单模块" -> 181
            "装配单模块" -> 189
            "公海客户分组" -> 197
            "Api文档" -> 205
            "列表搜索模块" -> 213
            "快速编辑" -> 221
            "仓库模块" -> 229
            "销售简报模块" -> 237
            "联系人模块" -> 245
            "合同产品折扣" -> 253
            "评论点赞模块" -> 261
            "退货退款" -> 269
            "分组模块" -> 285
            "员工模块" -> 293
            "角色模块" -> 301
            "文件柜" -> 309
            "模版模块" -> 317
            "供应商模块" -> 325
            "签到模块" -> 333
            "工作报告模块" -> 341
            "统计模块" -> 349
            "导入导出模块" -> 357
            "数据字典" -> 365
            "业绩目标模块" -> 373
            "多币种模块" -> 381
            "编码规则" -> 389
            "日志模块" -> 397
            "文件上传" -> 309
            "首页统计" -> 405
            "消息提醒" -> 413
            "工单模块" -> 421
            "资金管理" -> 429
            "产品和进销存优化" -> 133
            else -> 11
        }
    }

    fun formatReqBodyForm(reqParams: String): Array<ReqBodyFormPojo> {
        val reqParamsList: List<ApiDocParamsPojo>
        try {
            reqParamsList = JSON.parseArray(reqParams, ApiDocParamsPojo::class.java)
        } catch (e: Exception) {
            println("req参数($reqParams)解析成队列时出现异常$e")
            return emptyArray()
        }
        val array = Array(reqParamsList.size, { ReqBodyFormPojo() })
        reqParamsList.map { it ->
            ReqBodyFormPojo(required = if(it.required) "1" else "0", name = it.key, desc = it.name, example = it.memo)
        }.forEachIndexed { index, it ->
            array[index] = it
        }
        return array
    }

    fun formatResponseBody(responseBody: String?): String {
        if (responseBody.isNullOrEmpty()) {
            return ""
        }
        val responseBodyList: List<ApiDocResponsePojo>
        try {
            responseBodyList = JSON.parseArray(responseBody, ApiDocResponsePojo::class.java)
        } catch (e: Exception) {
            println("res参数($responseBody)解析成队列时出现异常$e")
            return ""
        }
        val responseDesc = StringBuilder("返回参数说明：<br >")
        for ((index, it) in responseBodyList.withIndex()) {
            val temp = index + 1
            var memo = ""
            if (!it.memo.isEmpty()) {
                memo = "，备注说明：${it.memo}"
            }
            responseDesc.append("  $temp. ${it.key}（${it.name}）的数据类型是${it.type}$memo<br >")
        }
        return responseDesc.toString()
    }
}