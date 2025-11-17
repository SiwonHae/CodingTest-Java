import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long[] cnt = new long[M];
        cnt[0] = 1;
        
        long result = 0;
        long sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            int remainder = (int) (sum % M);
            
            result += cnt[remainder];
            cnt[remainder]++;
        }
        
        
        bw.write(result + "");
        bw.flush();
    }
}