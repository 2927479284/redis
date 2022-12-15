package comfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {

    private static final JedisPool jedispool;

    static {
        //1.配置链接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);//最大连接数
        jedisPoolConfig.setMaxIdle(10);//最大空闲链接
        jedisPoolConfig.setMinIdle(0);//最小空闲链接
        jedisPoolConfig.setMaxWaitMillis(1000);
        //2.创建链接池对象
        jedispool = new JedisPool(jedisPoolConfig,"43.143.45.182",6379,1000,"xiaoyong66");
    }

    public static Jedis getJedis(){
        return jedispool.getResource();
    }
}
