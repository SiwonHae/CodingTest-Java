import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] prime;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];
        isPrime(N, prime);

        int result = 0;
        int start = 0, end = 0, sum = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) {
                    result++;
                }
                sum -= list.get(start++);
            } else {
                if (end == list.size()) {
                    break;
                }
                sum += list.get(end++);
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

        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                list.add(i);
            }
        }

        return prime;
    }
}