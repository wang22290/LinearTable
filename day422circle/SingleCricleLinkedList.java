package day422circle;

import day420.AbstractList;
import day422.SingleLink;

/**
 * created by wagn on 2020/4/22
 */
public class SingleCricleLinkedList<E>  extends AbstractList<E> {
    private Node<E> first;

    private static  class  Node<E>{
        E element;
        Node<E> next;
        public Node(E element,Node<E> next){
            this.element = element;
            this.next    = next;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element).append("_").append(next.element);
            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node node = node(index);
        E oldElement = (E) node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0){
            Node<E>  newFirst = new Node<E>(element,first);
            Node<E> last = (size == 0)? newFirst : node(size-1);
            last.next = newFirst;
            first = newFirst;
        }else {
            Node<E> prev = node(index -1);
            prev.next = new Node<E>(element,prev.next);
        }
        size ++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0){
            if (size == 1){
                first = null;
            }else {
                Node<E> last = node(size-1);
                first = first.next;
                last.next = first;
            }
        }else {
            Node<E> prev = node(index -1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            for (int i = 0; i < size; i++) {
                if (node(i).element == null){
                    return i;
                }
            }
        }else {
//            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                Node<E> node = node(i);
                if (node(i).element.equals(element)){
                    return i;
                }
//                node = node.next;
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
