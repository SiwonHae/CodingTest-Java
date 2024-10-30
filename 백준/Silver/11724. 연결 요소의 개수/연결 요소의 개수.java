import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(); // adj list
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (int vertex : graph.get(v)) {
            if (!visited[vertex]) {
                dfs(vertex);
            }
        }
    }
}