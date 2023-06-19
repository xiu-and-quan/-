package 代理.动态代理过程.imp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author shizq18
 * @Date 2023/6/16
 * @Description
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method invocation");
        Object result = method.invoke(obj, args);
        System.out.println("After method invocation");
        return result;
    }
}
