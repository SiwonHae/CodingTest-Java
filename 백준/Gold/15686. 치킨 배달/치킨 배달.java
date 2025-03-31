import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[] isSelected;
    static List<Point> chickens = new ArrayList<>();
    static List<Point> houses = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    chickens.add(new Point(i, j));
                } else if (board[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }

        // 치킨집 선택 여부를 저장하는 배열
        // [true, false, true, true] 라면 1번, 3번, 4번 치킨집이 선택되었다는 것.
        isSelected = new boolean[chickens.size()];

        combination(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void combination(int start, int depth) {
        if (depth == M) {
            dfs();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            isSelected[i] = true;
            combination(i + 1, depth + 1);
            isSelected[i] = false;
        }
    }

    public static void dfs() {
        int sumDistance = 0;

        for (Point house : houses) {
            int distance = Integer.MAX_VALUE;

            for (int i = 0; i < chickens.size(); i++) {
                if (isSelected[i]) {
                    Point chicken = chickens.get(i);
                    distance = Math.min(distance, calcDistance(house.y, house.x, chicken.y, chicken.x));
                }
            }

            sumDistance += distance;
        }

        result = Math.min(result, sumDistance);
    }

    public static int calcDistance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}