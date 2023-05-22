package com.sherry.new_sherry_product;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import java.net.SocketAddress;
import java.util.Map;

/**
 * @Author ： lpy
 * @Date : 16:54 2022/10/17
 */
public class MemcachedServer {
    private static MemcachedClient MEMCACHED_CLIENT;

    static {
        try {
            MEMCACHED_CLIENT = new MemcachedClient(
                    AddrUtil.getAddresses("127.0.0.1:11211"));
        } catch (Exception e) {
            System.err.println("Cannot init MEMCACHED Memcached Client");
        }
    }

    public static void set(String key, String value, Integer expireTime ) throws Exception {
        MEMCACHED_CLIENT.set(key, expireTime, value);
    }

    public static String get(String key) throws Exception {
        Object value = MEMCACHED_CLIENT.get(key);
        if (null != value)
            return value.toString();
        return null;
    }

    public static void main(String[] args) throws Exception {
        String mboss_sessions_cache = MemcachedServer.get("MBOSS_SESSIONS_CACHE");
        System.out.println(mboss_sessions_cache);

        String s = MemcachedServer.get("161665994790328");
        System.out.println(s);

        Map<SocketAddress, Map<String, String>> stats = MEMCACHED_CLIENT.getStats();
        System.out.println(stats);

    }

}
