import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int N, M, K;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(i, j);
            }
        }
        
        for (int i = 0; i < K; i++) {
            String find = br.readLine();
            bw.write(map.getOrDefault(find, 0) + "\n");
        }
        
        bw.flush();
    }
    
    public static void bfs(int startY, int startX) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startY, startX, String.valueOf(board[startY][startX])));
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int y = current.y;
            int x = current.x;
            String s = current.s;
            
            map.put(s, map.getOrDefault(s, 0) + 1);
            
            if (s.length() == 5) {
                continue;
            }
            
            for (int i = 0; i < 8; i++) {
                int ny = (y + dy[i] + N) % N;
                int nx = (x + dx[i] + M) % M;
                queue.offer(new Point(ny, nx, s + board[ny][nx]));
            }
        }
    }
    
    static class Point {
        int y;
        int x;
        String s;
        
        public Point(int y, int x, String s) {
            this.y = y;
            this.x = x;
            this.s = s;
        }
    }
}