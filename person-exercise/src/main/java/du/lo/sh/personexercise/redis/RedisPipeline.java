package du.lo.sh.personexercise.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName RedisPipeline
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/15 16:48
 * @Version 1.0
 */
public class RedisPipeline {

    private static final int taskCount = 50;
    private static final int batchSize = 10;
    private static final int cmdCount = 1000;
    private static volatile boolean isPipeline = false;

    public static JedisPool init(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxTotal(100);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);

        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379);
        return jedisPool;
    }


    static class TaskRunnable implements Runnable{

        private int threadNum;
        private CountDownLatch latch;
        public TaskRunnable(int threadNum, CountDownLatch latch){
            this.threadNum = threadNum;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("task [ " + threadNum + " ] start");
            if (isPipeline){

            } else {

            }

            System.out.println("task [ " + threadNum + " ] end");
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JedisPool jedisPool = init();
//        jedisPool.getResource();

        long beginTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        for (int i = 0; i< taskCount; i++){
            executorService.submit(new TaskRunnable(i, countDownLatch));
        }
        countDownLatch.await();
        System.out.println("==========" + countDownLatch.getCount());
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - beginTime));
        executorService.shutdownNow();
    }
}
