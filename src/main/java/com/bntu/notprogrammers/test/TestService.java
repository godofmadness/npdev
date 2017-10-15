package com.bntu.notprogrammers.test;

import com.bntu.notprogrammers.cache.Cachable;

/**
 * Created by mm on 10/15/17.
 */
public interface TestService {

    @Cachable
    int sum(int a, int b);
}
