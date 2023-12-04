package 优先级队列;

public class PriorityQueue<T extends Comparable<T>> {
    private T[] queue;
    private int size;

    public PriorityQueue(int capacity) {
        queue = (T[]) new Comparable[capacity];
        size = 0;
    }

    public void enqueue(T item) {
        if (size == queue.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        queue[size] = item;
        for (int i = size / 2; i >= 0; i--) {
            int parent = (i - 1) / 2;
            if (queue[i].compareTo(queue[parent]) < 0) {
                T temp = queue[i];
                queue[i] = queue[parent];
                queue[parent] = temp;
            } else {
                break;
            }
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }
        T item = queue[0];
        queue[0] = queue[size - 1];
        size--;
        for (int i = 0; i < size / 2; i++) {
            int leftChild = 2 * i + 1;
            int rightChild = leftChild + 1;
            int smallestIndex = leftChild;
            if (rightChild < size && queue[rightChild].compareTo(queue[leftChild]) < 0) {
                smallestIndex = rightChild;
            }
            if (queue[smallestIndex].compareTo(queue[i]) < 0) {
                T temp = queue[smallestIndex];
                queue[smallestIndex] = queue[i];
                queue[i] = temp;
            } else {
                break;
            }
        }
        return item;
    }
}