import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static int n;
    static int root;
    static int remove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n]; // 배열 초기화

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>(); // 요소 초기화
        }

        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());

            if (node == -1) {
                root = i;
            } else {
                tree[node].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        if (remove == root) {
            bw.write("0");
            bw.flush();
            return;
        }

        bw.write(String.valueOf(dfs(root)));
        bw.flush();
    }

    public static int dfs(int node) {

        int result = 0;
        int child = 0;

        for (int number : tree[node]) {
            if (number == remove) {
                continue;
            }

            result += dfs(number);
            child++;
        }

        if (child == 0) {
            return 1;
        }

        return result;
    }
}
