import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited1;  // 열(column) 체크
    static boolean[] visited2;  // 오른쪽 대각선 체크 (row + col)
    static boolean[] visited3;  // 왼쪽 대각선 체크 (row - col + N - 1)
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited1 = new boolean[N];
        visited2 = new boolean[2 * N - 1];
        visited3 = new boolean[2 * N - 1];

        backtrack(0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void backtrack(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited1[i] && !visited2[i + depth] && !visited3[depth - i + N - 1]) {
                visited1[i] = true;
                visited2[i + depth] = true;
                visited3[depth - i + N - 1] = true;
                backtrack(depth + 1);
                visited1[i] = false;
                visited2[i + depth] = false;
                visited3[depth - i + N - 1] = false;
            }
        }
    }
}