package day420;

import javax.xml.bind.Element;

public class CC_LinkedList<E>  extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (prev != null) {
                builder.append(prev.element);
            } else {
                builder.append("null");
            }

            builder.append("-").append(element).append("-");

            if (next != null) {
                builder.append(next.element);
            } else {
                builder.append("null");
            }
            return builder.toString();
        }
    }

    @Override
    public void clear() {
        first = null;
        last  = null;
        size = 0;
    }

    @Override
    public void add(E element) {

    }

    /**
     * 获取相关位置元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index 元素
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size){
            Node<E> oldLast = last;
            last = new Node<>(oldLast,element,null);
            if (oldLast == null){
                first = last;
            }else {
                oldLast.next = last;
            }
        }else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev,element,next);
            next.prev = node;
            if (prev == null){
                first = node;
            }else {
                prev.next = node;
            }
        }
        size++;
    }

    /**
     * 移除index 位置元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
//        prev.next = next;
        if (prev == null){
            first = next;
        }else {
            prev.next = next;
        }

        if (next == null){
            last = prev;
        }else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }


    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null){
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null)
                    return  i;
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element))
                    return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index 位置对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);
        //二分查找
        if (index < (size >> 1)){
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else {
            Node<E> node = last;
            for (int i = size -1; i > index ; i--) {
                node = node.prev;
            }
            return node;
        }
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

            string.append(node.element);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }


}
