import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board1;
    static int[][] board2;
    static int[] dy = {1, 0, -1, 0}; // 상, 우, 하, 좌 (시계방향)
    static int[] dx = {0, 1, 0, -1};
    static int result;
    static List<Point> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board1 = new int[N][M];
        board2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    cctv.add(new Point(i, j));
                }
                if (board1[i][j] == 0) {
                    result++;
                }
            }
        }

        for (int i = 0; i < (1 << (2 * cctv.size())); i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    board2[j][k] = board1[j][k];
                }
            }
            int tmp = i;

            for (int j = 0; j < cctv.size(); j++) {
                int dir = tmp % 4;
                tmp /= 4;

                int y = cctv.get(j).y;
                int x = cctv.get(j).x;

                if (board1[y][x] == 1) {
                    update(y, x, dir);
                } else if (board1[y][x] == 2) {
                    update(y, x, dir);
                    update(y, x, dir + 2);
                } else if (board1[y][x] == 3) {
                    update(y, x, dir);
                    update(y, x, dir + 1);
                } else if (board1[y][x] == 4) {
                    update(y, x, dir);
                    update(y, x, dir + 1);
                    update(y, x, dir + 2);
                } else {
                    update(y, x, dir);
                    update(y, x, dir + 1);
                    update(y, x, dir + 2);
                    update(y, x, dir + 3);
                }
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board2[j][k] == 0) {
                        cnt++;
                    }
                }
            }

            result = Math.min(result, cnt);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void update(int y, int x, int dir) {
        dir %= 4;
        while (true) {
            y += dy[dir];
            x += dx[dir];
            if (y < 0 || y >= N || x < 0 || x >= M || board2[y][x] == 6) {
                return;
            }
            if (board2[y][x] != 0) {
                continue;
            }
            board2[y][x] = 7;
        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}