package 剑指offer100;

import java.util.PriorityQueue;

public class 数据流中的中位数 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
class MedianFinder {

    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> up;

    int putWhichOneCount = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        //降序
        up = new PriorityQueue<>((x,y)->y-x);

        //升序
        low = new PriorityQueue<>();
    }

    public void addNum(int num) {

        //先加入low再弹出加入up，在弹出up，加入low
        if (putWhichOneCount % 2 ==0){
            up.add(num);
        }else {
            low.add(num);
        }
        putWhichOneCount++;
        if (putWhichOneCount > 1){
            //交换两个队列对头元素
            up.add(low.poll());
            low.add(up.poll());
        }
    }

    public double findMedian() {
        if (putWhichOneCount % 2 != 0){
            //基数个
            return (double)up.peek();
        }else {
            return ((double) up.peek() + (double)low.peek())/2;
        }
    }
}
