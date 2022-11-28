public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("副线程开始"));
        t1.start();
        t1.join();
        System.out.printf("主线程开始");
    }
}
