package com.xbongbong.yapi.dao

import com.xbongbong.yapi.entity.MongoUser

/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 20:26
 */
interface MongoUserDao {
    /**
     * 创建对象
     * @param user
     */
    fun save(user: MongoUser)
    /**
     * 根据用户名查询对象
     * @param lastName 用户名
     * @return
     */
    fun findByLastName(lastName: String): MongoUser
    /**
     * 更新对象
     * @param user
     */
    fun update(user: MongoUser)

    /**
     * 删除对象
     * @param id
     */
    fun deleteById(id: Int)
}