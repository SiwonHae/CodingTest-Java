import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int k;
    static int area;
    static List<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    area = 1;
                    dfs(i, j);
                    areaList.add(area);
                }
            }
        }

        Collections.sort(areaList);

        bw.write(areaList.size() + "\n");
        for (int a : areaList) {
            bw.write(a + " ");
        }
        bw.flush();
    }

    public static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (board[nx][ny] == 0 && !visited[nx][ny]) {
                    area++;
                    dfs(nx, ny);
                }
            }
        }
    }
}
