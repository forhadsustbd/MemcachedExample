package com.tigerit.memcached;

import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by forhad on 1/5/15.
 */
public class SpyMemcachedExample {

    public static void main(String[] args) {

        try {
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessfully");
            byte[] arr = new byte[1024];
            System.out.println("set status:"+mcc.set("tutorialspoint", 900, arr).isDone());
            //Get value from cache
            System.out.println("Get from Cache:"+mcc.get("tutorialspoint"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
