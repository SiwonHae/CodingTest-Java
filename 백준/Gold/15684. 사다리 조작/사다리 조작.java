import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited[a][b] = 1;
        }

        dfs(1, 0);

        if (result != Integer.MAX_VALUE) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("-1");
        }
        bw.flush();
    }

    public static void dfs(int start, int depth) {
        if (depth > 3 || depth >= result) {
            return;
        }

        if (isValid()) {
            result = Math.min(result, depth);
            return;
        }

        for (int i = start; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                 if (visited[i][j] >= 1 || visited[i][j - 1] >= 1 || visited[i][j + 1] >= 1) {
                    continue;
                 }
                 visited[i][j] = 1;
                 dfs(i, depth + 1);
                 visited[i][j] = 0; // 원복
            }
        }
    }

    public static boolean isValid() {
        for (int i = 1; i <= N; i++) {
            int start = i;

            for (int j = 1; j <= H; j++) {
                if (visited[j][start] >= 1) {
                    start++;
                } else if (visited[j][start - 1] >= 1) {
                    start--;
                }
            }

            if (start != i) {
                return false;
            }
        }

        return true;
    }

}
