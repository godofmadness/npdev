package com.bntu.notprogrammers;

import com.bntu.notprogrammers.cache.CacheEngine;
import com.bntu.notprogrammers.test.TestService;
import com.bntu.notprogrammers.test.TestServiceImpl;

/**
 * Hello world!
 *
 */
public class App {


    public static void main( String[] args ) throws InterruptedException {
        CacheEngine cacheEngine = new CacheEngine();
        TestService testService = new TestServiceImpl();

        TestService cachableTestService = cacheEngine.proxy(testService);


        System.out.println(cachableTestService.sum(2, 3));



        Thread.sleep(5000);
        System.out.println(cachableTestService.sum(2, 3));

        Thread.sleep(1000);
        System.out.println(cachableTestService.sum(3, 3));
    }


}
