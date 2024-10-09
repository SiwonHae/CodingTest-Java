import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>(); // adj list
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
    }

    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int n : tree.get(node)) {
            if (!visited[n]) {
                parent[n] = node;
                dfs(n);
            }
        }

    }
}