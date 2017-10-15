package com.bntu.notprogrammers.cache;

import java.lang.reflect.Proxy;

/**
 * Created by mm on 10/14/17.
 */
public class CacheEngine {


    public <T> T proxy(T object) {

        return  (T) Proxy.newProxyInstance(CacheEngine.class.getClassLoader(),
                object.getClass().getInterfaces(),
                new CachingDynamicInvocationHandler(object));
    }

}

