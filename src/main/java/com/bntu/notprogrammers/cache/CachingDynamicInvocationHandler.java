package com.bntu.notprogrammers.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by mm on 10/15/17.
 */
public class CachingDynamicInvocationHandler implements InvocationHandler {

    private Object obj;
    private HashMap<String, Method> invokableMethods = new HashMap();
    private CacheManager cacheManager = new CacheManager();



    public CachingDynamicInvocationHandler(Object obj) {
        this.obj = obj;
        for (Method method : this.obj.getClass().getMethods()) {
            if (method.getAnnotation(Cachable.class) != null) {
                this.invokableMethods.put(method.getName(), method);
            }
        }

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy method" + method.getName() + " is called");


        Object cachedVal = cacheManager.getCachedValue(method, args);

        if (cachedVal != null) {
            System.out.println("Cached Value" +  cachedVal.toString());
            return cachedVal;
        }

        if (invokableMethods.get(method.getName()) != null) {
            System.out.println("No cached value, invoking method");
            Object val = invokableMethods.get(method.getName()).invoke(this.obj, args);
            cacheManager.setCachedValue(val, method, args);
            return val;
        }

        throw new NotCachableMethodException();
    }
}
