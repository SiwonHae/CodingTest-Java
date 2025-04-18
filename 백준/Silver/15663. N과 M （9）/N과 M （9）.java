import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<String> resultSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        dfs(0);

        for (String s : resultSet) {
            bw.write(s + "\n");
        }
        bw.flush();
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result.get(i) + " ");
            }
            resultSet.add(sb.toString());
            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(list.get(i));
                dfs(depth + 1);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
}