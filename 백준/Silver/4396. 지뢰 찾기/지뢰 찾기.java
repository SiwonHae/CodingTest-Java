import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        boolean flag = false;
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == '*') {
                    board[i][j] = -1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'x') {
                    visited[i][j] = true;
                    
                    if (board[i][j] == -1) {
                        flag = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                
                board[i][j] = count(i, j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    if (board[i][j] == -1) {
                        bw.write("*");
                    } else {
                        bw.write(String.valueOf(board[i][j]));
                    }
                } else {
                    if (flag && board[i][j] == -1) {
                        bw.write("*");
                    } else {
                        bw.write(".");
                    }
                }
            }
            
            bw.write("\n");
        }
        
        bw.flush();
    }
    
    public static int count(int y, int x) {
        int cnt = 0;
        
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                continue;
            }
            
            if (board[ny][nx] == -1) {
                cnt++;
            }
        }
        
        return cnt;
    }
}