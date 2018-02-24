package com.xbongbong.yapi.entity.yapi

import com.xbongbong.yapi.pojo.yapi.QueryPathPojo
import com.xbongbong.yapi.pojo.yapi.ReqBodyFormPojo
import com.xbongbong.yapi.pojo.yapi.ReqHeadersPojo
import com.xbongbong.yapi.util.mongo.AutoIncKey
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 15:02
 */
@Document(collection = "interface")
data class MongoInterface(
        @AutoIncKey
        @Id
        var id: Int? = null,
        // 默认请求方式为"POST"
        @Field
        var method: String = "POST",
        // 所属接口分类的id（interface_cat）
        @Field("catid")
        var catId: Int = 0,
        // 接口名称
        @Field
        var title: String = "",
        // 接口地址
        @Field
        var path: String = "/",
        // 所属项目的id（project）
        @Field("project_id")
        var projectId: Int = 11,
        // 返回数据类型，默认"json"
        @Field("res_body_type")
        var resBodyType: String = "json",
        // 用户id
        @Field
        var uid: Int = 11,
        @Field("add_time")
        var addTime: Int = (Date().time / 1000L).toInt(),
        @Field("up_time")
        var upTime: Int = (Date().time / 1000L).toInt(),
        // 请求参数
        @Field("req_body_form")
        var reqBodyForm: Array<ReqBodyFormPojo> = emptyArray(),
        // 请求参数，Raw格式
        @Field("req_params")
        var reqParams: Array<String> = emptyArray(),
        @Field("req_headers")
        var reqHeaders: Array<ReqHeadersPojo> = emptyArray(),
        // 请求参数
        @Field("req_query")
        var reqQuery: Array<String> = emptyArray(),
        // 请求路径及参数，Get形式使用
        @Field("queryPath")
        var queryPath: QueryPathPojo = QueryPathPojo(),
        // 接口类型，默认static
        @Field
        var type: String = "static",
        // 接口完成情况（done/undone），默认未完成
        @Field
        var status: String = "undone",
        // TODO 允许修改的团队Id？
        @Field("edit_uid")
        var editUid: Int = 0,
        @Field("__v")
        var __v: Int = 0,
        // 是否对外开放，true/false
        @Field("api_opened")
        var apiOpened: Boolean = false,
        // 接口备注，<p>标签包裹
        @Field
        var desc: String = "<p></p>",
        // 请求类型，form/row
        @Field("req_body_type")
        var reqBodyType: String = "form",
        // 返回数据，json格式字符串
        @Field("res_body")
        var resBody: String = "{}"
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MongoInterface

        if (id != other.id) return false
        if (method != other.method) return false
        if (catId != other.catId) return false
        if (title != other.title) return false
        if (path != other.path) return false
        if (projectId != other.projectId) return false
        if (resBodyType != other.resBodyType) return false
        if (uid != other.uid) return false
        if (addTime != other.addTime) return false
        if (upTime != other.upTime) return false
        if (!Arrays.equals(reqBodyForm, other.reqBodyForm)) return false
        if (!Arrays.equals(reqParams, other.reqParams)) return false
        if (!Arrays.equals(reqHeaders, other.reqHeaders)) return false
        if (!Arrays.equals(reqQuery, other.reqQuery)) return false
        if (queryPath != other.queryPath) return false
        if (type != other.type) return false
        if (status != other.status) return false
        if (editUid != other.editUid) return false
        if (__v != other.__v) return false
        if (apiOpened != other.apiOpened) return false
        if (desc != other.desc) return false
        if (reqBodyType != other.reqBodyType) return false
        if (resBody != other.resBody) return false

        return true
    }

    override fun hashCode(): Int {
        var result = if (id == null) 0 else id!!.hashCode()
        result = 31 * result + method.hashCode()
        result = 31 * result + catId
        result = 31 * result + title.hashCode()
        result = 31 * result + path.hashCode()
        result = 31 * result + projectId.hashCode()
        result = 31 * result + resBodyType.hashCode()
        result = 31 * result + uid.hashCode()
        result = 31 * result + addTime
        result = 31 * result + upTime
        result = 31 * result + Arrays.hashCode(reqBodyForm)
        result = 31 * result + Arrays.hashCode(reqParams)
        result = 31 * result + Arrays.hashCode(reqHeaders)
        result = 31 * result + Arrays.hashCode(reqQuery)
        result = 31 * result + queryPath.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + editUid.hashCode()
        result = 31 * result + __v
        result = 31 * result + apiOpened.hashCode()
        result = 31 * result + desc.hashCode()
        result = 31 * result + reqBodyType.hashCode()
        result = 31 * result + resBody.hashCode()
        return result
    }
}