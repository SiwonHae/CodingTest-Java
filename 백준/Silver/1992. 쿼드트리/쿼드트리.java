import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void quadTree(int y, int x, int size) {
        if (isCompress(y, x, size)) {
            sb.append(board[y][x]);
        } else {
            int newSize = size / 2;

            sb.append("(");
            quadTree(y, x, newSize); // 왼쪽 위
            quadTree(y, x + newSize, newSize); // 오른쪽 위
            quadTree(y + newSize, x, newSize); // 왼쪽 아래
            quadTree(y + newSize, x + newSize, newSize); // 오른쪽 아래
            sb.append(")");
        }
    }

    public static boolean isCompress(int y, int x, int size) {
        if (size == 1) {
            return true;
        }

        int num = board[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
