package com.bntu.notprogrammers.test;

import com.bntu.notprogrammers.cache.Cachable;

/**
 * Created by mm on 10/14/17.
 */
public class TestServiceImpl implements TestService {

    @Cachable
    public int sum(int a, int b) {
        System.out.println("test service sum method called");
        return a + b;
    }
}
