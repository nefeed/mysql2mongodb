package com.xbongbong.yapi.util.mongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component
import org.springframework.util.ReflectionUtils


/**
 * 保存文档监听类<br >
 * 在保存对象时，通过反射方式为其生成ID
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 14:37
 */
@Component
class SaveEventListener : AbstractMongoEventListener<Any>() {

    @Autowired
    private val mongo: MongoTemplate? = null

    override fun onBeforeConvert(source: BeforeConvertEvent<Any>?) {
        if (source != null && source.source != null) {
            ReflectionUtils.doWithFields(source.source.javaClass) { field ->
                ReflectionUtils.makeAccessible(field)
                // 如果字段添加了我们自定义的AutoIncKey注解
                if (field.isAnnotationPresent(AutoIncKey::class.java)) {
                    // 设置自增ID
                    field.set(source.source, getNextId(source.source.javaClass.simpleName))
                }
            }
        }
    }

    /**
     * 获取下一个自增ID
     *
     * @param collName
     * 集合（这里用类名，就唯一性来说最好还是存放长类名）名称
     * @return 序列值
     */
    private fun getNextId(collName: String): Int? {
        val query = Query(Criteria.where("collName").`is`(collName))
        val update = Update()
        update.inc("seqId", 1)
        val options = FindAndModifyOptions()
        options.upsert(true)
        options.returnNew(true)
        val seq = mongo!!.findAndModify(query, update, options, SeqInfo::class.java)
        return seq.seqId
    }
}