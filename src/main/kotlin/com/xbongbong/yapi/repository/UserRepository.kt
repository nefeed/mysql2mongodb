package com.xbongbong.yapi.repository

import com.xbongbong.yapi.entity.MySqlUser
import org.springframework.data.jpa.repository.JpaRepository

/**
 * 用户仓库
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 16:33
 */
interface UserRepository: JpaRepository<MySqlUser, Long> {
    fun findByLastName(name: String): List<MySqlUser>
}