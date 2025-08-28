import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);

        if (S == 0) {
            result--;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void backtrack(int sum, int depth) {
        if (depth == N) {
            if (sum == S) {
                result++;
            }
            return;
        }

        backtrack(sum, depth + 1);
        backtrack(sum + arr[depth], depth + 1);
    }
}