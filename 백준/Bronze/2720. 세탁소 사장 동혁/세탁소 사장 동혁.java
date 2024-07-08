import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());

            int q = 0;
            int d = 0;
            int n = 0;
            int p = 0;

            // 25, 10, 5, 1 단위
            while (c - 25 >= 0) {
                c -= 25;
                q++;
            }

            while (c - 10 >= 0) {
                c -= 10;
                d++;
            }

            while (c - 5 >= 0) {
                c -= 5;
                n++;
            }

            while (c != 0) {
                c--;
                p++;
            }

            bw.write(q + " " + d + " " + n + " " + p + "\n");
            bw.flush();
        }
    }
}
