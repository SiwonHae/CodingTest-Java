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

        dfs(0, 1);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i : board) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            board[depth] = i;
            dfs(depth + 1, i);
        }
    }
}