import java.util.Scanner;

/**
 * 막대기 문제<br>
 * 알고리즘 분류 : 수학
 *
 * @author jayden-lee
 */
public class Main {

    private static int BAR_LENGTH = 64;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int barCnt = 0;

        while(n > 0) {
            if (BAR_LENGTH > n) {
                BAR_LENGTH /= 2;
            } else {
                barCnt++;
                n -= BAR_LENGTH;
            }
        }

        System.out.println(barCnt);

        scanner.close();
    }

}
