package 数据结构.链表;

import LRU.Node;

import java.util.LinkedList;

/**
 * @Author shizq18
 * @Date 2023/8/31
 * @Description
 */
public class MyLinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size;

    public MyLinkedList() {
    }

    /**
     * 给头节点直接加节点
     */
    private void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        // 更新头节点为新的节点
        first = newNode;
        // 说明链表为空，那此时头尾节点都为设置为现在的新节点
        if (f == null) {
            last = newNode;
        } else {
            // 节点不为空 更改节点指向
            f.pre = newNode;
        }
        size++;
    }

    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        // 更新最后节点为新加的节点
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size--;
     }

    private E unlinkFirst(Node<E> f) {
        return f.item;
    }



    static class Node<E> {

        E item;

        Node<E> pre;

        Node<E> next;

        public Node(Node<E> pre, E item, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}
