package problem3052;

import java.util.Scanner;

/**
 * 나머지 문제<br>
 * 알고리즘 분류 : 배열
 *
 * @author jayden-lee
 */
public class Main {

    private static final int N = 10;

    private static final int STANDARD_NUM = 42;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean[] checked = new boolean[42];

        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();

            if (number > 1000 || number < 0) {
                new RuntimeException("범위 밖의 숫자를 입력했습니다.");
            }

            if (!checked[number % STANDARD_NUM]) {
                count++;
            }
            checked[number % STANDARD_NUM] = true;

        }

        System.out.println(count);

    }

}
