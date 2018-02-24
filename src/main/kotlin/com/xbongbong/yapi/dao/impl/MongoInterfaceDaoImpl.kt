package com.xbongbong.yapi.dao.impl

import com.xbongbong.yapi.dao.MongoInterfaceDao
import com.xbongbong.yapi.entity.yapi.MongoInterface
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
class MongoInterfaceDaoImpl @Autowired constructor(val mongoTemplate: MongoTemplate) : MongoInterfaceDao {
    override fun list(): List<MongoInterface> {
        return mongoTemplate.findAll(MongoInterface::class.java)
    }

    override
    fun save(mongoInterface: MongoInterface): MongoInterface {
        mongoTemplate.save(mongoInterface)
        return mongoInterface
    }

    override fun findByTitle(title: String): MongoInterface {
        val query = Query(Criteria.where("title").`is`(title))
        return mongoTemplate.findOne(query, MongoInterface::class.java)
    }

    override
    fun update(mongoInterface: MongoInterface) {
        val query = Query(Criteria.where("id").`is`(mongoInterface.id))
        val update = Update().set("title", mongoInterface.title).set("path", mongoInterface.path)
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, MongoInterface::class.java)
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,MongoInterface.class);
    }

    override fun deleteById(id: Long) {
        val query = Query(Criteria.where("id").`is`(id))
        mongoTemplate.remove(query, MongoInterface::class.java)
    }
}
