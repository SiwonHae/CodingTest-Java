import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }

            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
            }

            if (sum == n) {
                bw.write(n + " = ");
                for (int i = 0; i < list.size() - 2; i++) {
                    bw.write(list.get(i) + " + ");
                }
                bw.write(list.get(list.size() - 2) + "\n");
            } else {
                bw.write(n + " is NOT perfect. \n");
            }
        }

        bw.flush();
    }
}
