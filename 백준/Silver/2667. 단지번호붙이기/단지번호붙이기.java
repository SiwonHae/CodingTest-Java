import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt = 1;
    static int totalCnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                bfs(i, j);
                result.add(cnt);
                cnt = 1;
                totalCnt++;
            }
        }
        
        bw.write(String.valueOf(totalCnt));
        bw.newLine();
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)));
            bw.newLine();
        }
        
        bw.flush();
    }
    
    public static void bfs(int startY, int startX) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startY, startX));
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }
                
                if (!visited[ny][nx] && board[ny][nx] == 1) {
                    cnt++;
                    queue.offer(new Point(ny, nx));
                    visited[ny][nx] = true;
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