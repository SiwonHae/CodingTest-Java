import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] board;
    static int x1, y1, x2, y2;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        y1 = Integer.parseInt(st.nextToken()) - 1;
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[N][M];

        bfs();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void bfs() {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {y1, x1});
        visited[y1][x1] = true;

        while (board[y2][x2] != '0') {
            result++;

            Queue<int[]> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];

                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + y;
                    int nx = dx[i] + x;

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;

                            if (board[ny][nx] != '0') {
                                board[ny][nx] = '0';
                                temp.add(new int[]{ny, nx});
                            } else {
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
            queue = temp;
        }
    }
}
