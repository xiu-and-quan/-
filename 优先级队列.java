import java.util.Comparator;
import java.util.PriorityQueue;

public class 优先级队列 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

}
