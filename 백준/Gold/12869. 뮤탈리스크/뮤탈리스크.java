import java.io.*;
import java.util.*;

public class Main {

    static int[][] attackCombi = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };
    static int[] scv;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        scv = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[scv[0] + 1][scv[1] + 1][scv[2] + 1];

        bfs(scv[0], scv[1], scv[2]);
        bw.write(String.valueOf(dp[0][0][0]));
        bw.flush();
    }

    public static void bfs(int startA, int startB, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startA, startB, startC});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];

            if (a == 0 && b == 0 && c == 0) {
                return;
            }

            for (int i = 0; i < 6; i++) {
                int[] attack = attackCombi[i];

                int na = Math.max(a - attack[0], 0);
                int nb = Math.max(b - attack[1], 0);
                int nc = Math.max(c - attack[2], 0);

                if (dp[na][nb][nc] == 0) {
                    queue.add(new int[]{na, nb, nc});
                    dp[na][nb][nc] = dp[a][b][c] + 1;
                }
            }
        }
    }
}
