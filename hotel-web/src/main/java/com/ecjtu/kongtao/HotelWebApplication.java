package com.ecjtu.kongtao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author sepK
 */
@SpringBootApplication
@EnableCaching
@EnableRedisHttpSession(redisNamespace = "springBootHotel")
@MapperScan(value = "com.ecjtu.kongtao.mapper")
@EnableScheduling
public class HotelWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelWebApplication.class, args);
    }
}
