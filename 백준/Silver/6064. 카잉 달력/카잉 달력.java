import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int k = -1;
            
            if (x == M) {
                x = 0;
            }
            
            if (y == N) {
                y = 0;
            }
            
            int l = lcm(M, N);
            for (int i = x; i <= l; i += M) {
                if (i == 0) {
                    continue;
                }
                
                if (i % N == y) {
                    k = i;
                }
            }
            
            bw.write(String.valueOf(k));
            bw.newLine();
        }
        
        bw.flush();
    }
    
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        
        return gcd(b % a, a);
    }
    
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}