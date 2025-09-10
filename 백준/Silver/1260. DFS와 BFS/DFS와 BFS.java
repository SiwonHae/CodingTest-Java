import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        bw.write(sb.toString() + "\n");

        sb = new StringBuilder();
        Arrays.fill(visited, false);
        bfs(V);
        bw.write(sb.toString() + "\n");

        bw.flush();
    }

    public static void dfs(int current) {
        visited[current] = true;
        sb.append(current).append(" ");

        for (int next : adjList.get(current)) {
            if (visited[next]) {
                continue;
            }
            dfs(next);
        }
    }

    public static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adjList.get(current)) {
                if (visited[next]) {
                    continue;
                }

                queue.offer(next);
                visited[next] = true;
                sb.append(next).append(" ");
            }
        }
    }
}