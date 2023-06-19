package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author shizq18
 * @Date 2023/6/6
 * @Description
 */
public class Dynamicproxy implements InvocationHandler {
    private Object targetObject;

    public Dynamicproxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始");
        Object invoke = method.invoke(targetObject, args);
        System.out.println("日志结束");
        return invoke;
    }
}

