import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] board;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1];

        // 'T'만 값을 갖는다!
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            int value = 1;
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == 'T') {
                    board[i] |= value;
                }
                value *= 2;
            }
        }

        go(1);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void go(int depth) {
        if (depth == N + 1) {
            int sum = 0;
            for (int i = 1; i <= (1 << (N - 1)); i *= 2) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if ((board[j] & i) != 0) {
                        cnt++;
                    }
                }
                sum += Math.min(cnt, N - cnt);
            }
            result = Math.min(result, sum);
            return;
        }

        go(depth + 1);
        board[depth] = ~board[depth];
        go(depth + 1);
    }
}