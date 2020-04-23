package day422;

import day420.Asserts;
import day420.List;
import day422circle.CricleLinkedList;
import day422circle.SingleCricleLinkedList;

/**
 * created by wagn on 2020/4/22
 */
public class day422Main {
    public static void main(String[] args) {

//        SingleLink<Integer> list = new SingleLink<Integer>();
        CricleLinkedList<Integer> list = new CricleLinkedList<>();

        list.add(11);
        System.out.println(list);
        list.add(22);
        System.out.println(list);
        list.add(33);
        System.out.println(list);
        list.add(44);
        System.out.println(list);
        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        System.out.println(list);
        list.remove(0); // [11, 66, 22, 33, 44, 77]
        System.out.println(list);
        list.remove(2); // [11, 66, 33, 44, 77]
        System.out.println(list);
        list.remove(list.size() - 1); // [11, 66, 33, 44]
        System.out.println(list);


        System.out.println(list.indexOf(66));
        System.out.println(list);
        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);
    }
}
