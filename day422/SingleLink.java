package day422;

import day420.AbstractList;

import javax.xml.soap.Node;

/**
 * created by wagn on 2020/4/22
 */
public class SingleLink<E> extends AbstractList<E> {
    private Node<E> first;
    private  static  class Node<E>{
        E element;
        Node<E> next;
        public Node (E element,Node<E> next){
            this.element = element;
            this.next =  next;
        }
    }

    /**
     * 获取index位置element
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 修改制定位置element
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
       Node<E> node = node(index);
       E oldElement = node.element;
       node.element = element;
       return  oldElement;
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
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0){
            first = new Node<>(element,first);
        }else {
            Node<E> node = node(index-1);
            node.next = new Node<>(element,node.next);
        }
        size ++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0){
            first = node(0).next;
        }else {
            Node<E> prev = node(index-1);
            node = prev.next;
            prev.next = node.next;

        }
        size --;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null){
                    return i;
                }
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)){
                    return i;
                }
                node = node.next;
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
}
