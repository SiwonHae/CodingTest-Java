import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Character> list = new ArrayList<>();
    static boolean[][] visited;
    static char[][] board;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 1);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void dfs(int y, int x, int cnt) {
        result = Math.max(result, cnt);

        list.add(board[y][x]);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }

            if (!visited[ny][nx] && !list.contains(board[ny][nx])) {
                visited[ny][nx] = true;
                dfs(ny, nx, cnt + 1);
                visited[ny][nx] = false; // 원복
                list.remove(list.size() - 1); // 원복
            }
        }
    }
}
