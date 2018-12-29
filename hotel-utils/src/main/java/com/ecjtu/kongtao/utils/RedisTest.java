package com.ecjtu.kongtao.utils;

/**
 * @author sepK
 */
public class RedisTest {
/*    @Test
    public void demo(){
        *//*Jedis jedis = new Jedis("172.16.2.129",7369);
        System.out.println(jedis.ping());*//*
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("172.16.2.129",7000));
        nodes.add(new HostAndPort("172.16.2.129",7001));
        nodes.add(new HostAndPort("172.16.2.129",7002));
        nodes.add(new HostAndPort("172.16.2.129",7003));
        nodes.add(new HostAndPort("172.16.2.129",7004));
        nodes.add(new HostAndPort("172.16.2.129",7005));


        JedisCluster jedisCluster = new JedisCluster(nodes);
        //jedisCluster.set("xx","x");
        System.out.println(jedisCluster.get("xx"));
    }*/
}
