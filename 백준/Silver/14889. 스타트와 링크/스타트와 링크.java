import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;
    static int teamMember;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        teamMember = N / 2;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    public static void backtrack(int depth, int idx) {
        if (depth == teamMember) {
            int startSum = 0;
            int linkSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        startSum += S[i][j] + S[j][i];
                    } else if (!selected[i] && !selected[j]) {
                        linkSum += S[i][j] + S[j][i];
                    }
                }
            }

            int diff = Math.abs(startSum - linkSum);
            min = Math.min(min, diff);

            return;
        }

        for (int i = idx; i < N; i++) {
            selected[i] = true;
            backtrack(depth + 1, i + 1);
            selected[i] = false;
        }
    }
}