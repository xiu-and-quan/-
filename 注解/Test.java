package 注解;

import java.lang.reflect.Method;

/**
 * @Author shizq18
 * @Date 2023/10/12
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Method method = null;
        try {
            method = MyClass.class.getMethod("myMethod");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            String value = annotation.value();
            // do something with the value
            System.out.println("annotation!");
        }
    }

}
