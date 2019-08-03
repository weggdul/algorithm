package baekjoon.problem1085;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wedul {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        System.out.println(calcShortestLength(x, y, w, h));
    }

    private static int calcShortestLength(int x, int y, int w, int h) {
       List<Integer> list = new ArrayList<>();

       list.add(w - x);
       list.add(h - y);
       list.add(y);
       list.add(x);

       return list.stream().reduce(Integer::min).get();
    }
}