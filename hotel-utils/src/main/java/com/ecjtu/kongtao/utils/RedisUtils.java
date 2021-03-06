package com.ecjtu.kongtao.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author SepK
 */
@SuppressWarnings({"unchecked", "WeakerAccess"})
@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @param key   键
     * @param value 值
     * @param <K>
     */
    public <K> void put(String key, K value, int expire) {
        if (expire > 0) {
            redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    public void deleteKeysPrefix(String prefix) {
        Set<String> keys = redisTemplate.keys(prefix);
        if (!ObjectUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

}
