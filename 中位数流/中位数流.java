package 中位数流;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 中位数流 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }

}
class MedianFinder {
    PriorityQueue<Integer> xiaoDingDui;
    PriorityQueue<Integer> daDingDui;
    int count;
    public MedianFinder() {
        xiaoDingDui = new PriorityQueue<>();
        daDingDui = new PriorityQueue<>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        if (count%2 == 0){
            xiaoDingDui.add(num);
        }else {
            daDingDui.add(num);
        }
        count++;
        if(xiaoDingDui.peek()!=null && daDingDui.peek()!=null) {
            int xiaoDingDuiValie = xiaoDingDui.peek();
            int daDingDuiValue = daDingDui.peek();
            if (xiaoDingDuiValie < daDingDuiValue){
                xiaoDingDuiValie = xiaoDingDui.poll();
                daDingDuiValue = daDingDui.poll();
                daDingDui.add(xiaoDingDuiValie);
                xiaoDingDui.add(daDingDuiValue);
            }
        }

    }

    public double findMedian() {
        if (xiaoDingDui.size() > daDingDui.size()){
            return (double)xiaoDingDui.peek();
        }
        if (xiaoDingDui.size() < daDingDui.size()){
            return (double)daDingDui.peek();
        }
        return ((double)xiaoDingDui.peek() + (double)daDingDui.peek())/2;
    }
}
