import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int total = 0;
    static int cnt = 1;
    static List<Integer> cntList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                board[i][j] = c - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    cntList.add(cnt);
                    cnt = 1;
                    total++;
                }
            }
        }

        bw.write(total + "\n");
        Collections.sort(cntList);
        for (int i : cntList) {
            bw.write(i + "\n");
        }

        bw.flush();
    }

    public static void dfs(int y, int x) {
        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                continue;
            }

            if (board[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx);
                cnt++;
            }
        }
    }
}