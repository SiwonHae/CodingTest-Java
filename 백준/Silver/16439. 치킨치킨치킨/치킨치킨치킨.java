import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int start, int depth) {
        if (depth == 3) {
            int sum = 0; // 각 회원의 가장 높은 선호도 합 == 만족도의 합

            for (int i = 0; i < N; i++) {
                int like = 0;
                for (int j = 0; j < M; j++) {
                    if (visited[j]) {
                        like = Math.max(like, board[i][j]); // i번째 회원의 가장 높은 선호도
                    }
                }
                sum += like;
            }

            result = Math.max(result, sum); // 만족도의 합 갱신
            return;
        }

        for (int i = start; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}