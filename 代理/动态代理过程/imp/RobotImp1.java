package 代理.动态代理过程.imp;

import 代理.动态代理过程.Robot;

/**
 * @Author shizq18
 * @Date 2023/6/16
 * @Description
 */
public class RobotImp1 implements Robot {
    @Override
    public void doWork() {
        System.out.println("robot1号开始干活了！");
    }
}
