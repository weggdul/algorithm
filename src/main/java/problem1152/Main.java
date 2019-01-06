package problem1152;

import java.util.Scanner;

/**
 * 단어의 개수 문제<br>
 * 알고리즘 분류 : 문자열 처리
 *
 * @author jayden-lee
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] arrStringSplit = text.split(" ");

        int count = 0;

        for (String str : arrStringSplit) {
            if (!str.isEmpty()) {
                ++count;
            }
        }

        System.out.println(count);

        scanner.close();

    }
}
