import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int two = 0;
        int five = 0;
        
        for (int i = 1; i <= N; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                two++;
                temp /= 2;
            }
            
            temp = i;
            while (temp % 5 == 0) {
                five++;
                temp /= 5;
            }
        }
        
        bw.write(Math.min(two, five) + "");
        bw.flush();
    }
}