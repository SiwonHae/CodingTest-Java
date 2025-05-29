import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] oper;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        oper = new int[4];
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, numbers[0]);

        bw.write(max + "\n" + min);
        bw.flush();
    }

    public static void backtrack(int depth, int result) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                int num = numbers[depth];

                int next = result;

                if (i == 0) {
                    next += num;
                } else if (i == 1) {
                    next -= num;
                } else if (i == 2) {
                    next *= num;
                } else if (i == 3) {
                    if (next < 0) {
                        next = -(next) / num * -1;
                    } else {
                        next /= num;
                    }
                }

                backtrack(depth + 1, next);
                oper[i]++; // backtrack
            }
        }
    }
}