package problem11403;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 경로 찾기 문제<br>
 * 알고리즘 분류 : DFS
 *
 * @author jayden-lee
 */
public class Main {

    private static int number;

    // 처음 입력 받는 인접 행렬
    private static int[][] originalMatrix;

    // 정점에서 방문할 수 있는 경로를 체크하는 인접 행렬
    private static int[][] visitedMatrix;

    // 각 정점에 방문했는지 체크하는 변수
    private static boolean[] visitedVertex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 정점 개수
        number = scanner.nextInt();

        originalMatrix = new int[number][number];
        visitedMatrix = new int[number][number];
        visitedVertex = new boolean[number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                originalMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < number; i++) {
            findEdgePathByDFS(i);

            // 방문할 수 있는 정점 값을 담은 visitedVertex를 기준으로
            // visitedMatrix에 값을 설정한다.
            for (int j = 0; j < number; j++) {
                if (visitedVertex[j]) {
                    visitedMatrix[i][j] = 1;
                }
            }

            // 방문 체크하는 배열을 초기화한다.
            Arrays.fill(visitedVertex, false);
        }

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(visitedMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void findEdgePathByDFS(int startVertex) {
        for (int i = 0; i < number; i++) {
            // 정점에 방문했는지 또는 방문할 수 있는지 값을 체크
            if (!visitedVertex[i] && originalMatrix[startVertex][i] == 1) {
                visitedVertex[i] = true;
                findEdgePathByDFS(i);
            }
        }
    }
}
