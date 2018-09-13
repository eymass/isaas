package com.isaas.isaas.Handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy Handler
 * 1. Handle Main COntroller Requests
 */
public class MainHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return 42;
    }
}
