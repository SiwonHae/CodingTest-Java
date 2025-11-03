import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        long result = 0;
        long r = 31;
        long M = 1234567891;
        long pow = 1;
        for (int i = 0; i < input.length(); i++) {
            long c = input.charAt(i) - 'a' + 1;
            result = (result + c * pow) % M;
            pow = (pow * r) % M;
        }
        
        bw.write(result + "");
        bw.flush();
    }
}