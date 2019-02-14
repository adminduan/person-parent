package du.lo.sh.personjdk;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ConcurrentLinkedQueueDemo
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/1 11:16
 * @Version 1.0
 */
public class ConcurrentLinkedQueueDemo {

    private static ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

//    public static void main(String[] args) {
//        System.out.print("\r" + "aa" + "\n");
////        ConcurrentLinkedQueueDemo concurrentLinkedQueueDemo = new ConcurrentLinkedQueueDemo();
////
////        ConcurrentLinkedQueueDemo t =  new ConcurrentLinkedQueueDemo();
////        System.out.println(t);
////        ConcurrentLinkedQueueDemo tail = new ConcurrentLinkedQueueDemo();
////        System.out.println(tail);
////        System.out.println(t != (t = tail) ? t : "");
//
//        boolean addResult = concurrentLinkedQueue.offer("a");
////        concurrentLinkedQueue.poll();
//        System.out.println("addResult: " + addResult);
//        boolean offerResult = concurrentLinkedQueue.offer("b");
//        offerResult = concurrentLinkedQueue.offer("a");
//        System.out.println("offerResult: " + offerResult);
//
//
//        System.out.println(concurrentLinkedQueue.size());
//        String result = concurrentLinkedQueue.peek();
//        System.out.println(result);
//    }


//    private static AtomicInteger guidSequence = new AtomicInteger(0);
//    public static long getGuid() {
//
//        int id = guidSequence.incrementAndGet();
//        if(id >= Constants.GUID_PER_MIN) {
//            synchronized(guidSequence) {
//                if(id >= Constants.GUID_PER_MIN) {
//                    guidSequence.set(0);
//                    id = 0;
//                }
//            }
//        }
//
//        return  (System.currentTimeMillis() / 60000 * 100000000000L) + (id * 100) + config.getServerId();
//    }



}
