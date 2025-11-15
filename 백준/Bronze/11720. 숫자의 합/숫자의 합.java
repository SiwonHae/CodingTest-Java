import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();
        
        int result = 0;
        for (char c : num.toCharArray()) {
            result += c - '0';
        }
        
        bw.write(result + "");
        bw.flush();
    }
}