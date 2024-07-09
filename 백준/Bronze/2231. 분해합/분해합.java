import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            String number = String.valueOf(i);
            String[] num = String.valueOf(i).split("");

            int sum = Integer.parseInt(number);
            for (int j = 0; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
            }

            if (sum == n) {
                bw.write(String.valueOf(i));
                bw.flush();
                return;
            }
        }

        bw.write("0");
        bw.flush();
    }
}
