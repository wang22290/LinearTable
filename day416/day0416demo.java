package day416;
import day416.TimeTool.Task;
import day416.ArrayList;
import java.sql.Time;
import java.util.*;
//import java.util.ArrayList;

public class day0416demo {
    public static void main(String[] args) {
        int[] array = new int []{11,22};


    }

    public  static  int fib(int n){
        if (n <= 1){
            return n;
        }
        return  fib(n -1) + fib(n- 2);
    }
    public  static  int fib2(int n){
        if (n <= 1){
            return n;
        }
        int first = 0;
        int secont = 1;
        for (int i = 0; i < n -1; i++) {
             int sum = first + secont;
             first = secont;
             secont = sum;
        }
        return secont;
    }

}

