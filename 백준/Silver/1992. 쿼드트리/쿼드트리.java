import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void quadTree(int y, int x, int size) {
        if (isCompress(y, x, size)) {
            sb.append(board[y][x]);
            return;
        }

        int half = size / 2;

        sb.append("(");
        quadTree(y, x, half);
        quadTree(y, x + half, half);
        quadTree(y + half, x, half);
        quadTree(y + half, x + half, half);
        sb.append(")");
    }

    public static boolean isCompress(int y, int x, int size) {
        int video = board[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (video != board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}