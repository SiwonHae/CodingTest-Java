import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1000001];
        isPrime(prime);

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            int cnt = 0;
            for (int j = 2; j <= num / 2; j++) {
                if (prime[j] && prime[num - j]) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
    }

    public static boolean[] isPrime(boolean[] prime) {
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000000; j+= i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}
