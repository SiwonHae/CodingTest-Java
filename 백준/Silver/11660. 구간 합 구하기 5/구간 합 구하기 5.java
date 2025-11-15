import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] pSum = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for  (int j = 1; j <= N; j++) {
                pSum[i][j] = pSum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < M; i++) {
            int result = 0;
            
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            for (int y = y1; y <= y2; y++) {
                result += pSum[y][x2] - pSum[y][x1 - 1];
            }
            
            bw.write(result + "\n");
        }
        
        bw.flush();
    }
}