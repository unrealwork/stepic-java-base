package org.stepic.java.collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RevertStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (i % 2 == 1) list.add(num);
            i++;
        }
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.print(String.format("%d ", integer));
        }
        System.out.flush();
    }
}
