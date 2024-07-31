import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int twoCnt = 0;
            int fiveCnt = 0;
            
            for (int j = 2; j <= n; j *= 2) {
                twoCnt += n / j;    
            }
            
            for (int j = 5; j <= n; j*= 5) {
                fiveCnt += n / j;
            }
            
            bw.write(Math.min(twoCnt, fiveCnt) + "\n");
        }

        bw.flush();
    }
}
