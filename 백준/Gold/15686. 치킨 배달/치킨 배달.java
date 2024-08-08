import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    house.add(new int[] {i, j});
                } else if (board[i][j] == 2) {
                    chicken.add(new int[] {i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];

        // 1. 치킨집 M개를 고른다.
        // 2. 최소 도시의 치킨 거리를 구한다.

        backtracking(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void backtracking(int depth, int start) {
        if (depth == M) {
            int sum = 0;

            for (int i = 0; i < house.size(); i++) {
                int[] h = house.get(i);
                int hy = h[0];
                int hx = h[1];

                int min = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int[] s = chicken.get(j);
                        int sy = s[0];
                        int sx = s[1];
                        min = Math.min(min, Math.abs(hy - sy) + Math.abs(hx - sx));
                    }
                }
                sum += min;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            backtracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}