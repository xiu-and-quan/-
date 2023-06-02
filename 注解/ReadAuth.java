package 注解;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @Author shizq18
 * @Date 2023/5/30
 * @Description
 */
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadAuth {
}
class TestReadAuth {
    @ReadAuth
    static void readTest() {
        System.out.println("Read Auth Test");
    }

    static {
        /*
        	JDK 8 及其i之前的版本需要设置 sun.misc.ProxyGenerator.saveGeneratedFiles 属性为 true，JDK 8 之后版本
        	则需要设置 jdk.proxy.ProxyGenerator.saveGeneratedFiles 属性为 true，具体可以查看 ProxyGenerator  的saveGeneratedFiles 定义的属性

                配置这个属性的目的在于保存在程序运行过程中生成的 Proxy 对象，
                假设获取注解的过程是通过代理的方式来实现的，通过配置该属性就能够保存中间的代理对象
        */
        //  System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> cls = TestReadAuth.class;
        Method method = cls.getDeclaredMethod("readTest"); // 通过反射获取类的方法

        ReadAuth readAuth = method.getAnnotation(ReadAuth.class); // 获取方法上的注解
    }
}
