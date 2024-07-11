import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int start = 666;
        while (n != cnt) {
            start++;

            if (String.valueOf(start).contains("666")) {
                cnt++;
            }
        }

        bw.write(String.valueOf(start));
        bw.flush();
    }
}
