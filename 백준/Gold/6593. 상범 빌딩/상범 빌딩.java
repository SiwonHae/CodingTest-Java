import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] board;
    static int[][][] dist;
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Point startPos;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
        
            board = new char[L][R][C];
            dist = new int[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    Arrays.fill(dist[i][j], -1);
                }
            }
            
            for (int height = 0; height < L; height++) {
                for (int i = 0; i < R; i++) {
                    String input = br.readLine();
                    for (int j = 0; j < C; j++) {
                        board[height][i][j] = input.charAt(j);
                        
                        if (board[height][i][j] == 'S') {
                            startPos = new Point(height, i, j);
                        }
                    }
                }
                
                br.readLine();
            }
            
            int result = bfs();
            
            if (result == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + result + " minute(s).\n");
            }
        }

        bw.flush();
    }
    
    public static int bfs() {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(startPos);
        dist[startPos.z][startPos.y][startPos.x] = 0;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int z = current.z;
            int y = current.y;
            int x = current.x;
            
            for (int i = 0; i < 6; i++) {
                int nz = dz[i] + z;
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                
                if (nz < 0 || nz >= L || ny < 0 || ny >= R || nx < 0 || nx >= C || dist[nz][ny][nx] != -1) {
                    continue;
                }
                
                if (board[nz][ny][nx] == '.') {
                    queue.offer(new Point(nz, ny, nx));
                    dist[nz][ny][nx] = dist[z][y][x] + 1;
                }
                
                if (board[nz][ny][nx] == 'E') {
                    dist[nz][ny][nx] = dist[z][y][x] + 1;
                    return dist[nz][ny][nx];
                }
            }
        }
        
        return -1;
    }
    
    static class Point {
        int z;
        int y;
        int x;
        
        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}