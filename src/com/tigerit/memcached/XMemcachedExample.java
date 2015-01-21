package com.tigerit.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * Created by forhad on 1/5/15.
 */
public class XMemcachedExample {
    public static void main(String[] args) {

        try {
            MemcachedClient client=new XMemcachedClient("localhost",11511);

            byte[] data = new byte[20000];
            Random random = new Random();

            long prevTime = System.currentTimeMillis();
            for (int i = 1; i <= 1000000; i++) {
                random.nextBytes(data);
                client.set(i + "", 3600, data);
                byte[] temp = client.get(i+"");
                if(!Arrays.equals(temp,data)) {
                    System.out.println("Not Found");
                }
                if(i%1000==0) {
                    long curTime = System.currentTimeMillis();
                    double time = (curTime - prevTime)/1000.0;
                    prevTime = curTime;
                    System.out.println("i:"+i+"     time = " + time);
                }
            }
            //store a value for one hour(synchronously).
            /*client.set("key",3600,"value");
            String str = client.get("key",2000);
            System.out.println("str = " + str);*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
}
