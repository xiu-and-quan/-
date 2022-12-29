package LRU;

public class DoubleList {
    int capacity;
    int size;
    Node head;
    Node tail;
    public DoubleList(int capacity) {
        size = 0;
        this.capacity = capacity;
        //头节点和尾节点
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    public void addLast(Node node){
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        size++;
    }
    public void removeFirst(){
        head.next.next.pre = head;
        head.next = head.next.next;
        size--;
    }
    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }
    public int getSize(){
        return size;
    }

    public Node getFirst() {
        return head.next;
    }
}
