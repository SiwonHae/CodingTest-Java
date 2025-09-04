import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] S;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            
            S = new int[k];
            arr = new int[6];
            
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            backtrack(0, 0);
            
            bw.write(sb.toString());
            bw.write("\n");
            sb = new StringBuilder();
        }
        
        bw.flush();
    }
    
    public static void backtrack(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < k; i ++) {
            arr[depth] = S[i];
            backtrack(i + 1, depth + 1);
        }
    }
}