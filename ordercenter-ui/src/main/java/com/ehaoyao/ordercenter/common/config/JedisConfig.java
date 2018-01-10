package com.ehaoyao.ordercenter.common.config;

import com.ehaoyao.ordercenter.common.properties.JeeSiteProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

    @Autowired
    JeeSiteProperties jeeSiteProperties;

    @Bean
    JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大能够保持idel状态的对象数
        jedisPoolConfig.setMaxIdle(300);
        // 最大分配的对象数
        jedisPoolConfig.setMaxTotal(60000);
        // 当调用borrow Object方法时，是否进行有效性检查
        jedisPoolConfig.setTestOnBorrow(true);
        return jedisPoolConfig;
    }

    @Bean
    JedisPool jedisPool(){
        return new JedisPool(jedisPoolConfig(),jeeSiteProperties.getCache().getRedis().getHost() ,jeeSiteProperties.getCache().getRedis().getPort() );
    }
}
