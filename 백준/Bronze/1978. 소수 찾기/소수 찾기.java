import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean[] prime = new boolean[num + 1];
            isPrime(num, prime);

            if (prime[num]) {
                result++;
            }
        }

        bw.write(String.valueOf(result));
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
