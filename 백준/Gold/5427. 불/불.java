import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int w, h;
    static char[][] board;
    static int[][] fireDist;
    static int[][] sDist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Deque<Point> fireQueue = new ArrayDeque<>();
    static Deque<Point> sQueue = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            board = new char[h][w];
            fireDist = new int[h][w];
            sDist = new int[h][w];
            
            for (int i = 0; i < h; i++) {
                Arrays.fill(fireDist[i], -1);
                Arrays.fill(sDist[i], -1);
            }
            
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = input.charAt(j);
                    
                    if (board[i][j] == '*') {
                        fireQueue.offer(new Point(i, j));
                        fireDist[i][j] = 0;
                    }
                    
                    if (board[i][j] == '@') {
                        sQueue.offer(new Point(i, j));
                        sDist[i][j] = 0;
                    }
                }
            }
            
            fireBfs();
            int result = sBfs();
            
            if (result == -1) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(result + "\n");
            }
            
            fireQueue.clear();
            sQueue.clear();
        }
        
        bw.flush();
    }
    
    public static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            Point current = fireQueue.poll();
            int y = current.y;
            int x = current.x;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    continue;
                }
                
                if (fireDist[ny][nx] == -1 && board[ny][nx] != '#') {
                    fireDist[ny][nx] = fireDist[y][x] + 1;
                    fireQueue.offer(new Point(ny, nx));
                }
            }
        }
    }
    
    public static int sBfs() {
        while (!sQueue.isEmpty()) {
            Point current = sQueue.poll();
            int y = current.y;
            int x = current.x;
            
            if (y == 0 || y == (h - 1) || x == 0 || x == (w - 1)) {
                return sDist[y][x] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    continue;
                }
                
                if (sDist[ny][nx] == -1 && board[ny][nx] != '#') {
                    if (fireDist[ny][nx] == -1 || sDist[y][x] + 1 < fireDist[ny][nx]) {
                        sDist[ny][nx] = sDist[y][x] + 1;
                        sQueue.offer(new Point(ny, nx));
                    }
                }
            }
        }
        
        return -1;
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