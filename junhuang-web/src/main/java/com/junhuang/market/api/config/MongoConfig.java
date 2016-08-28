package com.junhuang.market.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

/**
 * Created by pengweiyuan on 7/10/16.
 */
@Configuration
public class MongoConfig {

    @Bean
    public MongoClientFactoryBean mongoClient() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        //* mogo.setHost("192.168.1.102");*//*
        mongo.setHost("localhost");
        mongo.setPort(27017);
        //*MongoClientOptions.Builder builder=MongoClientOptions.builder();
//        builder.connectTimeout(1000);
//        builder.connectionsPerHost(10);//对mongo实例来说,每个host允许连接的最大连接数,这些连接空闲时会放入池中,如果连接被耗尽,任何请求连接的操作会被阻塞等待连接可用,推荐配置10.

//        ConnectionPoolSettings.Builder conne=ConnectionPoolSettings.builder();
//        conne.maxSize()
//        MongoClientOptions options=MongoClientOptions.builder().build();*//*

        return mongo;
    }

//    public @Bean Mongo mongo() throws Exception {
//        return new Mongo("localhost");
//    }
//
//    public @Bean
//    MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), "mydatabase");
//    }


  /*  @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        Mongo mongo = new MongoClient("127.0.0.1", 27017);
       // UserCredentials userCredentials = new UserCredentials("", ""); // username and password
        return new SimpleMongoDbFactory(mongo, "test");
    }*/


//    @Bean
//    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
//        Mongo mongo = new MongoClient("127.0.0.1", 27017);
//        UserCredentials userCredentials = new UserCredentials("", ""); // username and password
//        return new SimpleMongoDbFactory(mongo, "sample", userCredentials);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws UnknownHostException {
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//        return mongoTemplate;
//    }
}
