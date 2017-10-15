package com.bntu.notprogrammers.cache;

/**
 * Created by mm on 10/15/17.
 */
public class NotCachableMethodException extends RuntimeException {

    public NotCachableMethodException(String message) {
        super(message);
    }

    public NotCachableMethodException() {
        super();
    }
}
