import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
