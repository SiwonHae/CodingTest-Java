import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int INF = 1000000000;
    static int[][] dist;
    static int[][] next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        next = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            next[a][b] = b;
        }

        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                        next[j][k] = next[j][i];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(dist[i][j] + " ");
                }
            }
            bw.newLine();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    bw.write("0\n");
                    continue;
                }

                List<Integer> path = new ArrayList<>();
                int start = i;

                while (start != j) {
                    path.add(start);
                    start = next[start][j];
                }

                path.add(j);

                bw.write(path.size() + " ");
                for (int x : path) {
                    bw.write(x + " ");
                }
                bw.newLine();
            }
        }

        bw.flush();
    }
}