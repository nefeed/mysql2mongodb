package com.xbongbong.yapi.entity


/**
 * 客户持久层类
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 16:29
 */
//@Entity
//@Table(name = "yapi_user")
data class MySqlUser(
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    var firstName: String = "",
    var lastName: String = ""
) {
    override fun toString(): String {
        return "MySqlUser(id=$id, firstName='$firstName', lastName='$lastName')"
    }
}