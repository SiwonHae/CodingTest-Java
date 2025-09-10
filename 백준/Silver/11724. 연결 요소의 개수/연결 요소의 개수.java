import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void bfs() {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            result++;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : adjList[current]) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}