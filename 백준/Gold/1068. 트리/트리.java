import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] tree;
    static int root, remove;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        if (remove == root) {
            bw.write("0");
            bw.flush();
            return;
        }

        dfs(root);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int node) {
        if (node == remove) {
            return;
        }

        int childCnt = 0;
        for (int child : tree[node]) {
            if (child != remove) {
                childCnt++;
                dfs(child);
            }
        }

        if (childCnt == 0) {
            result++;
        }
    }
}