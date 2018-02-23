package com.xbongbong.yapi.config

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.convert.CustomConversions
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext


/**
 * MongoDB的配置文件
 * @author  章华隽
 * @mail    nefeed@163.com
 * @time    2018-02-23 15:16
 */
@Configuration
class MongoConfig {
    // 去除入库时保存_class字段
    @Bean
    fun mappingMongoConverter(factory: MongoDbFactory, context: MongoMappingContext,
                              beanFactory: BeanFactory): MappingMongoConverter {
        val dbRefResolver = DefaultDbRefResolver(factory)
        val mappingConverter = MappingMongoConverter(dbRefResolver, context)
        try {
            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions::class.java))
        } catch (ignore: NoSuchBeanDefinitionException) {
        }

        // Don't save _class to mongo
        mappingConverter.typeMapper = DefaultMongoTypeMapper(null)

        return mappingConverter
    }
}