import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String isbn = br.readLine();
        
        int sum = 0;
        int removeIdx = 0;
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c == '*') {
                removeIdx = i;
                continue;
            }
            
            int num = c - '0';
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum += num * 3;
            }
        }
        
        int result = 0;
        int mul = 1;
        if (removeIdx % 2 != 0) {
            mul = 3;
        }
        for (int i = 0; i < 10; i++) {
            if ((sum + i * mul) % 10 == 0) {
                result = i;
                bw.write(result + "");
                bw.flush();
                return;
            }
        }
        
        
        bw.flush();
    }
}