package com.datamargin.utils;

import redis.clients.jedis.Jedis;

import java.util.Map;

public class DataUtils {
    Jedis jedis;

    public DataUtils(){
        jedis = new Jedis("120.55.43.230",6379);
    }

    public Map<String,String> query(String key){
        Map<String,String> map = jedis.hgetAll(key);
        return map;
    }
}
