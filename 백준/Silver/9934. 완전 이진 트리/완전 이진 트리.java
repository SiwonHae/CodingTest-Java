import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] arr;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        arr = new int[(int) (Math.pow(2, K) - 1)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            tree.add(new ArrayList<>());
        }

        search(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            for (int j : tree.get(i)) {
                bw.write(j + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static void search(int start, int end, int depth) {
        if (depth == K) {
            return;
        }

        int middle = (start + end) / 2;

        tree.get(depth).add(arr[middle]);

        search(start, middle - 1, depth + 1); // 왼쪽 subtree
        search(middle + 1, end, depth + 1); // 오른쪽 subtree
    }
}
