import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] board;
    static int[][] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        board = new char[H][W];
        result = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            Arrays.fill(result[i], -1);
            
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 'c' && result[i][j] == -1) {
                    go(i, j);
                }
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
    
    public static void go(int y, int x) {
        result[y][x] = 0;
        
        for (int i = x + 1; i < W; i++) {
            if (board[y][i] == 'c') {
                continue;
            }
            
            result[y][i] = result[y][i - 1] + 1;
        }
    }
}