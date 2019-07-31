package problem1026;

import java.util.*;

/**
 * 보물 문제<br>
 * 알고리즘 분류 : 정렬
 *
 * @author jayden-lee
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            a.add(scanner.nextInt());
        }

        for (int i = 0; i < N; i++) {
            b.add(scanner.nextInt());
        }

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += a.get(i) * b.get(i);
        }

        System.out.println(result);

        scanner.close();
    }

}
