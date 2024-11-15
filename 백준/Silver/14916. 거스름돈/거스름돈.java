import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        while (true) {
            if (n % 5 == 0) {
                result += n / 5;
                break;
            }
            n -= 2;
            result++;
        }

        if (n < 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
        }

        bw.flush();
    }
}