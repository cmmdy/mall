package com.zwt.mall.service;

/**
 * @Author zhouwentao
 * @Date 2021-08-11-9:36 上午
 * @Email zhouwt@shuyilink.com
 */
public interface RedisService {

    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);


    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);


    /**
     * 设置超期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);


    /**
     * 删除数据
     * @param key
     */
    void revome(String key);

    /**
     * 自增操作
     * @param key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key, long delta);
}
