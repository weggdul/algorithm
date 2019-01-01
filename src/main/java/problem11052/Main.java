package problem11052;

import java.util.Scanner;

/**
 * 카드 구매하기 문제<br>
 * 알고리즘 분류 : DP
 *
 * @author jayden-lee
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        // 각 카드팩 가격
        int[] priceItems = new int[N + 1];

        // 각 카드팩 최대 가격
        int[] maxPriceItems = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            priceItems[i] = scanner.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int tempMaxPrice = 0;

            for (int j = 1; j <= i; j++) {
                tempMaxPrice = Math.max(tempMaxPrice, priceItems[j] + maxPriceItems[i - j]);
            }
            maxPriceItems[i] = tempMaxPrice;
        }

        // N일 때 최대 가격
        System.out.println(maxPriceItems[N]);

        scanner.close();
    }
}
