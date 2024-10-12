import java.util.*;
import java.io.*;

public class Main {

    static int R, C, N;
    static char[][] board;
    static int[][] boomTime;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        boomTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'O') {
                    boomTime[i][j] = 3;
                }
            }
        }

        int time = 0;

        while (time++ < N) {
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == '.') {
                            board[i][j] = 'O';
                            boomTime[i][j] = time + 3;
                        }
                    }
                }
            } else if (time % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if(boomTime[i][j] == time) {
                            board[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int ny = i + dy[k];
                                int nx = j + dx[k];

                                if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                                    continue;
                                }

                                if (board[ny][nx] == 'O' && boomTime[ny][nx] != time) {
                                    board[ny][nx] = '.';
                                    boomTime[ny][nx] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}