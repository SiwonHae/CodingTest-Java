import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = i;
            int sum = num;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                bw.write(String.valueOf(i));
                bw.flush();
                return;
            }
        }

        bw.write("0");
        bw.flush();
    }
}