package baekjoon.problem1094;

import java.util.Scanner;
import java.util.Stack;

/**
 * algorithm
 *
 * @author wedul
 * @since 2019-08-03
 **/
public class Wedul {

    private static final int INITIAL_STICK_LENGTH = 64;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println(calculateMakeStickCnt(scan.nextInt()));
    }

    private static int calculateMakeStickCnt(int inputStickLength) {
        Stack<Integer> stickLengths = new Stack<>();
        stickLengths.push(INITIAL_STICK_LENGTH);

        while (!isEqualInputStickLength(stickLengths, inputStickLength)) {
            int minStickLength = stickLengths.pop() / 2;

            stickLengths.push(minStickLength);
            if (getStickLength(stickLengths) < inputStickLength) {
                stickLengths.push(minStickLength);
            }
        }

        return stickLengths.size();
    }

    private static boolean isEqualInputStickLength(Stack<Integer> stickLengths, int inputStickLength) {
        return getStickLength(stickLengths) == inputStickLength;
    }

    private static int getStickLength(Stack<Integer> stickLengths) {
        return stickLengths.stream().reduce(Integer::sum).get();
    }

}
