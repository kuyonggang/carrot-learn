package com.carrot.learn;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;

/**
 * 监控redis控制台的操作命令
 */
public class RedisMonitor {

    static class MonitorTask implements Runnable{
        private Jedis client;
        MonitorTask(Jedis jedis){
            this.client = jedis;
        }

        @Override
        public void run() {
            client.monitor(new JedisMonitor() {
                @Override
                public void onCommand(String command) {
                    System.out.println(command);
                }
            });
        }
    }

    public static void main(String[] args) {
        Jedis monitor = new Jedis("182.92.171.123",6379);
        Thread monitorTask = new Thread(new MonitorTask(monitor));
        monitorTask.start();
    }
}
