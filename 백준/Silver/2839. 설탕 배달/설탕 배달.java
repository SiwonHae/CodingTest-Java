import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        while (N >= 0) {

            if (N % 5 == 0) {
                result += N / 5;
                break;
            } else {
                N -= 3;
                result++;
            }

        }

        if (N < 0) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(result));
        }

        bw.flush();
    }
}