import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] posFreq = new int[1000002];
        int[] negFreq = new int[1000002];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) {
                negFreq[-num]++;
            } else {
                posFreq[num]++;
            }
        }

        for (int i = 1000000; i >= 1; i--) {
            for (int j = 0; j < negFreq[i]; j++) {
                bw.write("-" + i  + "\n");
            }
        }

        for (int i = 0; i < posFreq.length; i++) {
            for (int j = 0; j < posFreq[i]; j++) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }
}