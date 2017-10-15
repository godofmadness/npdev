package com.bntu.notprogrammers.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by mm on 10/15/17.
 */
public class DynamicInvocationHandler implements InvocationHandler {

    private Object obj;
    private HashMap<String, Method> invokableMethods = new HashMap();



    public DynamicInvocationHandler(Object obj) {
        this.obj = obj;
        for (Method method: this.obj.getClass().getMethods()) {
            if (method.getAnnotation(Cachable.class) != null) {
                this.invokableMethods.put(method.getName(), method);
            }
        }

        System.out.println("methods with required annotation" + invokableMethods.toString());
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("proxy method" + method.getName() + " is called");
        if (invokableMethods.get(method.getName()) != null) {
            return invokableMethods.get(method.getName()).invoke(this.obj, args);
        }

        throw new NotCachableMethodException();
    }
}
