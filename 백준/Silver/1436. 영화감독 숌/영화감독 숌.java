import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int i = 666;
        while (cnt != N) {
            i++;

            String s = String.valueOf(i);
            if (s.contains("666")) {
                cnt++;
            }
        }

        bw.write(String.valueOf(i));
        bw.flush();
    }
}