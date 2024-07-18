import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            while (true) {
                if (num == 0 || num == 1 || num == 2) {
                    bw.write("2 \n");
                    break;
                }

                if (isPrime(num)) {
                    bw.write(num + "\n");
                    break;
                }
                num++;
            }
        }

        bw.flush();
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
