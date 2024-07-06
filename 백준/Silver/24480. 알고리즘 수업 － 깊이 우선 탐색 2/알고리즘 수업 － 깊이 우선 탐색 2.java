import java.io.*;
import java.util.*;

public class Main {

    static int[] result;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int cnt = 1;

    public static void dfs(int r) {
        visited[r] = true;
        result[r] = cnt++;

        Collections.sort(graph.get(r), Collections.reverseOrder());

        for (int x : graph.get(r)) {
            if (!visited[x]) {
                dfs(x);
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

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }
}
