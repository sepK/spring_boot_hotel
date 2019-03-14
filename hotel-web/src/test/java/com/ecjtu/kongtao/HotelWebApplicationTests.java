package com.ecjtu.kongtao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelWebApplicationTests {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	@Test
	public void testSet() {
		this.redisTemplate.opsForValue().set("study", "java");
		System.out.println(this.redisTemplate.opsForValue().get("study"));
	}

}
