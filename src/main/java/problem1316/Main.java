package problem1316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 그룹 단어 체커 문제<br>
 * 알고리즘 분류 : 문자열 처리
 *
 * @author jayden-lee
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(scanner.next());
        }

        int count = 0;

        for (String word : words) {
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        char[] arrWord = word.toCharArray();
        boolean[] visited = new boolean[26];

        for (int i = 0; i < arrWord.length; i++) {
            if (visited[arrWord[i] - 'a']) {
                return false;
            }

            char character = arrWord[i];
            visited[arrWord[i] - 'a'] = true;

            while (i < (arrWord.length-1)) {
                if (character != arrWord[++i]) {
                    i--;
                    break;
                }
            }
        }

        return true;
    }

}
