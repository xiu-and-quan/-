package 代理.Imp;

import 代理.Service;

/**
 * @Author shizq18
 * @Date 2023/6/6
 * @Description
 */
public class ServiceImpl implements Service {
    // 业务方法
    @Override
    public void reduceStock() {
        System.out.println("扣减库存开始");
    }
}
