import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i <= N; i++) {
            String[] num = String.valueOf(i).split("");

            int sum = i;
            for (int j = 0; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
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