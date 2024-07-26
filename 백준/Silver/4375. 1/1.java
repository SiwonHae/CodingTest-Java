import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = "";
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            int start = 1;
            int cnt = 1;
            // 1 11 111 1111 등
            while (start % n != 0) {
                start = (start * 10 + 1) % n;
                cnt++;
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
    }
}
