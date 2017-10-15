package com.bntu.notprogrammers.cache;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mm on 10/15/17.
 */
public class CacheManager {


    private Map<String, Object> cache = new HashMap<String, Object>();

    private String createKey(Method method, Object[] args) {
        String key = method.toString();
        for (Object arg: args) {
            key += arg.toString();
        }

        System.out.println("key " + key);
        return key;
    }

    public Object getCachedValue(Method method, Object[] args) {
        return this.cache.get(createKey(method, args));
    }

    public void setCachedValue(Object val, Method method, Object[] args) {
        this.cache.put(createKey(method, args), val);
    }
}
