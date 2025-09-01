import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int l;
    static int[][] board;
    static int[][] dist;
    static int result;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static Deque<Point> queue = new ArrayDeque<>();
    static int ty, tx;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            dist = new int[l][l];
            
            for (int i = 0; i < l; i++) {
                Arrays.fill(dist[i], -1);
            }
            
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                
                if (i == 0) {
                    board[y][x] = 1;
                    dist[y][x] = 0;
                    queue.add(new Point(y, x));
                } else {
                    board[y][x] = 2;
                    ty = y;
                    tx = x;
                }
            }
            
            bfs();
            bw.write(dist[ty][tx] + "\n");
            result = 0;
            queue.clear();
        }
        
        bw.flush();
    }
    
    public static void bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;
            
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= l || nx < 0 || nx >= l) {
                    continue;
                }
                
                if (dist[ny][nx] == -1) {
                    dist[ny][nx] = dist[y][x] + 1;
                    queue.add(new Point(ny, nx));
                }
            }
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