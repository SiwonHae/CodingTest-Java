import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] board;
    static int[][] fireDist;
    static int[][] jihunDist;
    static Queue<int[]> fireQueue;
    static Queue<int[]> jihunQueue;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];

        fireQueue = new LinkedList<>();
        jihunQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'F') {
                    fireQueue.add(new int[] {i, j});
                    fireDist[i][j] = 1;
                } else if (board[i][j] == 'J') {
                    jihunQueue.add(new int[] {i, j});
                    jihunDist[i][j] = 1;
                }
            }
        }

        fireBfs();
        result = jihunBfs();

        if (result == -1) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(String.valueOf(result));
        }

        bw.flush();
    }

    public static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (board[ny][nx] != '#' && fireDist[ny][nx] == 0) {
                        fireDist[ny][nx] = fireDist[y][x] + 1;
                        fireQueue.add(new int[] {ny, nx});
                    }
                }
            }
        }
    }

    public static int jihunBfs() {
        while (!jihunQueue.isEmpty()) {
            int[] current = jihunQueue.poll();
            int y = current[0];
            int x = current[1];

            if (y == 0 || y == R - 1 || x == 0 || x == C - 1) {
                return jihunDist[y][x];
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (board[ny][nx] != '#' && jihunDist[ny][nx] == 0) {
                        if (fireDist[ny][nx] == 0 || jihunDist[y][x] + 1 < fireDist[ny][nx]) {
                            jihunDist[ny][nx] = jihunDist[y][x] + 1;
                            jihunQueue.add(new int[] {ny, nx});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
