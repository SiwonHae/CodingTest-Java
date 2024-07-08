import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[n + 1];
        isPrime(n, prime);

        int sum = 0;
        int min = 0;
        boolean flags = false;
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sum += i;
                if (!flags) {
                    min = i;
                    flags = true;
                }
            }
        }

        if (sum == 0) {
            bw.write("-1");
            bw.flush();
            return;
        }

        bw.write(sum + "\n" + min);
        bw.flush();
    }

    public static boolean[] isPrime(int num, boolean[] prime) {

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (prime[i]) {
                for (int j = i * i; j <= num; j+= i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}
