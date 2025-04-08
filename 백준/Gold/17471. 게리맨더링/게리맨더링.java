import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] popular;
    static int[][] adj;
    static int result = Integer.MAX_VALUE;
    static int[] district;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        popular = new int[N + 1];
        adj = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            popular[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int node = Integer.parseInt(st.nextToken());
                adj[i][node] = 1;
                adj[node][i] = 1;
            }
        }

        for (int i = 1; i < (1 << N) - 1; i++) {
            district = new int[N + 1];
            visited = new boolean[N + 1];

            int group1Start = -1;
            int group2Start = -1;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    district[j + 1] = 1;
                    group1Start = j + 1;
                } else {
                    district[j + 1] = 0;
                    group2Start = j + 1;
                }
            }

            int[] group1 = dfs(1, group1Start);
            int[] group2 = dfs(0, group2Start);

            if (group1[0] + group2[0] == N) {
                result = Math.min(result, Math.abs(group1[1] - group2[1]));
            }
        }

        if (result == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
        }
        bw.flush();
    }

    public static int[] dfs(int value, int depth) {
        visited[depth] = true;

        int[] result = {1, popular[depth]};

        for (int i = 1; i <= N; i++) {
            if (adj[depth][i] != 1) {
                continue;
            }
            if (district[i] != value) {
                continue;
            }
            if (visited[i]) {
                continue;
            }

            int[] temp = dfs(value, i);
            result[0] += temp[0];
            result[1] += temp[1];
        }

        return result;
    }
}