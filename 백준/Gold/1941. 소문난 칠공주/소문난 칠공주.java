import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static boolean[] check;
    static int result;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        board = new char[5][5];
        check = new boolean[25];
        
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        
        backtrack(0, 0);
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    
    public static void backtrack(int current, int depth) {
        if (depth == 7) {
            if (isValid()) {
                result++;
            }
            return;
        }
        
        for (int i = current; i < 25; i++) {
            check[i] = true;
            backtrack(i + 1, depth + 1);
            check[i] = false;
        }
    }
    
    public static boolean isValid() {
        Deque<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        int sCnt = 0;
        int connected = 0;
        
        for (int i = 0; i < 25; i++) {
            if (check[i]) {
                int y = i / 5;
                int x = i % 5;
                queue.offer(new Point(y, x));
                visited[y][x] = true;
                break;
            }
        }
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;
            connected++;
            
            if (board[y][x] == 'S') {
                sCnt++;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                
                int pos = ny * 5 + nx;
                if (!check[pos]) {
                    continue;
                }
                
                queue.offer(new Point(ny, nx));
                visited[ny][nx] = true;
            }
        }
        
        return connected == 7 && sCnt >= 4;
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