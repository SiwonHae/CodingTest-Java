import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int sum, result;
    static List<int []> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        list.clear();
                        visited[i][j] = true;
                        list.add(new int[] {i, j});
                        sum = board[i][j];
                        dfs(i, j);

                        if (list.size() == 1) {
                            continue;
                        }

                        for (int[] pos : list) {
                            board[pos[0]][pos[1]] = sum / list.size();
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) {
                break;
            }
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (!visited[ny][nx]) {
                    if (Math.abs(board[ny][nx] - board[y][x]) >= L && Math.abs(board[ny][nx] - board[y][x]) <= R) {
                        visited[ny][nx] = true;
                        list.add(new int[] {ny, nx});
                        sum += board[ny][nx];
                        dfs(ny, nx);
                    }
                }
            }
        }
    }
}