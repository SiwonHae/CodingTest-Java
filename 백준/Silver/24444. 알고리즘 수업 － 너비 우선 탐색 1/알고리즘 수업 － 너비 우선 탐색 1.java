import java.io.*;
import java.util.*;

public class Main {

    static int[] result;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int cnt = 1;

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(r);
        visited[r] = true;
        result[r] = cnt++;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);

                if (!visited[v]) {
                    visited[v] = true;
                    result[v] = cnt++;
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        result = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }
}
