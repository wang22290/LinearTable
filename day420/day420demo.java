package day420;

import java.util.ArrayList;

public class day420demo {
    public static void main(String[] args) {
        List<Integer> list = new CC_LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

       Integer a = list.remove(1);
        System.out.println(list);


    }
}
