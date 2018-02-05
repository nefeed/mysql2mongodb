package com.xbongbong.yapi.dao.impl

import com.xbongbong.yapi.dao.MongoUserDao
import com.xbongbong.yapi.entity.MongoUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component


/**
 *
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-05 20:27
 */
@Component
class MongoUserDaoImpl @Autowired constructor(val mongoTemplate: MongoTemplate) : MongoUserDao {

    override
    fun save(user: MongoUser) {
        mongoTemplate.save(user)
    }

    override fun findByLastName(lastName: String): MongoUser {
        val query = Query(Criteria.where("lastName").`is`(lastName))
        return mongoTemplate.findOne(query, MongoUser::class.java)
    }

    override
    fun update(user: MongoUser) {
        val query = Query(Criteria.where("id").`is`(user.id))
        val update = Update().set("firstName", user.firstName).set("lastName", user.lastName)
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, MongoUser::class.java)
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,MongoUser.class);
    }

    override fun deleteById(id: Long) {
        val query = Query(Criteria.where("id").`is`(id))
        mongoTemplate.remove(query, MongoUser::class.java)
    }
}
