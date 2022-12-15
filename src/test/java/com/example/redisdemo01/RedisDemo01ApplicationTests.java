package com.example.redisdemo01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class RedisDemo01ApplicationTests {

    private Jedis jedis;


    //1.在调用别的方法之前先调用这个
    @BeforeEach
    void contextLoads() {
        //1.建立一个连接
        jedis = new Jedis("43.143.45.182", 6379);
        //2.设置账号密码
        jedis.auth("xiaoyong66");
        //3.选择一下redis的库[默认选择第一个]
        jedis.select(0);
    }

    @Test
    public void test1(){
        jedis.set("xiaoyong","66666");
        String xiaoyong = jedis.get("xiaoyong");
        System.out.println(xiaoyong);
    }

}
