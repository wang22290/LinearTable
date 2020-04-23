package day422circle;

import day420.AbstractList;
import org.omg.CORBA.NO_IMPLEMENT;

import javax.xml.soap.Node;

/**
 * created by wagn on 2020/4/22
 */
public class CricleLinkedList<E> extends AbstractList<E> {
    Node<E> first;
    Node<E> last;
    private static  class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev,Node<E> next,E element){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {

        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast,first,element);
            if (oldLast == null){ // 这是链表添加的第一个元素
                first = last;
                first.next = first;
                first.prev = first;
            }else {       // 在最后一个位置添加元素
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node next = node(index);
            Node prev = next.prev;
            Node<E> newNode = new Node<>(prev,next,element);
            next.prev = newNode;
            prev.next = newNode;
            if (next == first){ // index == 0在第一位置添加元素
                first = newNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
     return remove(node(index));
    }

    public E remove(Node<E> node){
        if (size == 1){
            first = null;
        }else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if (node == first){ //第一额元素
                first = next;
            }
            if (node == last){ //最后一个额元素
                last = prev;
            }
        }
        size --;
        return  node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){

        }else {
            for (int i = 0; i < size; i++) {
                Node<E> node = node(i);
                if (node(i).element.equals(element)){
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }


}
