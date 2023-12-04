package 代理.动态代理过程;

import 代理.动态代理过程.imp.MyInvocationHandler;
import 代理.动态代理过程.imp.RobotImp1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * @Author shizq18
 * @Date 2023/6/16
 * @Description
 */
public class Test1 {
    public static void main(String[] args) {
        /*Robot obj = new RobotImp1();
        MyInvocationHandler handler = new MyInvocationHandler(obj);
        Robot proxy = (Robot) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                new Class[] { Robot.class },
                handler
        );
        proxy.doWork();*/
        new ArrayList<>();
        System.out.println("success");
    }
}
