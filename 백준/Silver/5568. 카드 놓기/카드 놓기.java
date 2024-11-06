import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static String[] board;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        dfs(0, board[0]);

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    public static void dfs(int depth, String s) {
        if (depth == k) {
            set.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, s + board[i]);
                visited[i] = false;
            }
        }
    }
}