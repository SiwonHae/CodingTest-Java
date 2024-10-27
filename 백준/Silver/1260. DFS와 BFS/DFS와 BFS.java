import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static List<List<Integer>> board;
    static boolean[] visited;
    static List<Integer> dfsList = new ArrayList<>();
    static List<Integer> bfsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        board = new ArrayList<>(); // adjacency list
        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board.get(a).add(b);
            board.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(board.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        visited = new boolean[N + 1];
        bfs(V);

        for (int i : dfsList) {
            bw.write(i + " ");
        }
        bw.write("\n");

        for (int i : bfsList) {
            bw.write(i + " ");
        }

        bw.flush();
    }

    public static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        dfsList.add(v);

        for (int i : board.get(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsList.add(current);

            for (int i : board.get(current)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}