package com.xbongbong.yapi.dao

import com.xbongbong.yapi.entity.yapi.MongoInterface

/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 20:26
 */
interface MongoInterfaceDao {
    /**
     * 展示所有接口
     */
    fun list(): List<MongoInterface>
    /**
     * 创建对象
     * @param mongoInterface
     */
    fun save(mongoInterface: MongoInterface): MongoInterface
    /**
     * 根据接口名查询对象
     * @param title 接口名
     * @return
     */
    fun findByTitle(title: String): MongoInterface
    /**
     * 更新对象
     * @param mongoInterface
     */
    fun update(mongoInterface: MongoInterface)

    /**
     * 删除对象
     * @param id
     */
    fun deleteById(id: Long)
}