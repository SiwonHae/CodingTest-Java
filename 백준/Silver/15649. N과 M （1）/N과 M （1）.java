import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] board;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[M];
        visited = new boolean[N];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i : board) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                board[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}