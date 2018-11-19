package com.plugins;

import com.annotation.ConsumIntercepts;
import com.annotation.ConsumSignature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sc on 2018/11/14.
 */
public class Plugins implements InvocationHandler {

    private final Object _target;
    private final ConsumInterceptor consumInterceptor;
    private final Map<Class<?>, Set<Method>> _signatureMaps;

    public Plugins(Object _target, ConsumInterceptor consumInterceptor, Map<Class<?>, Set<Method>> _signatureMaps) {
        this._target = _target;
        this.consumInterceptor = consumInterceptor;
        this._signatureMaps = _signatureMaps;
    }

 /*   public static Object warp(Object target, ConsumInterceptor consumInterceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{ConsumInterceptor.class}, new Plugins(target));
    }*/

    private static Map<Class<?>,Set<Method>> getSignatureMap(ConsumInterceptor inc){
        ConsumIntercepts consumIntercepts = inc.getClass().getAnnotation(ConsumIntercepts.class);
        if(consumIntercepts==null){
            return null;
        }
        ConsumSignature[] consumSignatures=consumIntercepts.value();
        if(consumSignatures==null || consumSignatures.length<1){
            return null;
        }
        Map<Class<?>, Set<Method>> signatureMaps = new HashMap<>();
        for(ConsumSignature consumSignature:consumSignatures){

        }
        return null;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
