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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1]; // adj matrix
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
            board[b][a] = 1;
        }

        dfs(1);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int start) {

        if (visited[start]) {
            return;
        }

        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (board[start][i] == 1 && !visited[i]) {
                result++;
                dfs(i);
            }
        }
    }

}