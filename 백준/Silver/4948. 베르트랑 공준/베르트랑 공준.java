import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                bw.flush();
                return;
            }

            int cnt = 0;

            for (int i = num + 1; i <= 2 * num; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }
    }

    public static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
