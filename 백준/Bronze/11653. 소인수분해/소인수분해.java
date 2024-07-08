import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int idx = 2;

        if (n == 1) {
            return;
        }

        while (n != 1) {
            if (n % idx == 0) {
                n /= idx;
                bw.write(idx + "\n");
            } else {
                idx++;
            }
        }

        bw.flush();
    }
}
