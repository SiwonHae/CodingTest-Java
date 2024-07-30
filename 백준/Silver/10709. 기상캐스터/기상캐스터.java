import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(board[i], -1);
        }

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = s.charAt(j);

                if (c == 'c') {
                    board[i][j] = w + 1; // 시작 구름의 위치 표시
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == w + 1) {
                    board[i][j] = 0;
                    for (int k = j + 1; k < w; k++) {
                        if (board[i][k] != w + 1) {
                            board[i][k] = board[i][k - 1] + 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(board[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
