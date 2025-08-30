import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] board;
    static int[][][] dist;
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int result;
    static Deque<Point> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        board = new int[N][M][H];
        dist = new int[N][M][H];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[j][k][i] = Integer.parseInt(st.nextToken());
                    
                    if (board[j][k][i] == 1) {
                        queue.add(new Point(j, k, i));
                    }
                    
                    if (board[j][k][i] == 0) {
                        dist[j][k][i] = -1;
                    }
                }
            }
        }
        
        bfs();
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[j][k][i] == 0) {
                        bw.write("-1");
                        bw.flush();
                        return;
                    }
                    
                    result = Math.max(result, dist[j][k][i]);
                }
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    
    public static void bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;
            int z = current.z;
            
            for (int i = 0; i < 6; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nz = z + dz[i];
                
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || nz < 0 || nz >= H) {
                    continue;
                }
                
                if (dist[ny][nx][nz] == -1 && board[ny][nx][nz] == 0) {
                    board[ny][nx][nz] = 1;
                    dist[ny][nx][nz] = dist[y][x][z] + 1;
                    queue.add(new Point(ny, nx, nz));
                }
            }
        }
    }
    
    static class Point {
        int y;
        int x;
        int z;
        
        public Point(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
}