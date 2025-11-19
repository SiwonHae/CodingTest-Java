import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while (start <= end) {
            if (sum == N) {
                result++;
            }
            
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum >= N) {
                sum -= start;
                start++;
            }
        }
        
        bw.write(result + "");
        bw.flush();
    }
}