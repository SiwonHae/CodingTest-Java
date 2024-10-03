import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] time = new int[102];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int arrive = Integer.parseInt(st.nextToken());
            int leave = Integer.parseInt(st.nextToken());

            for (int j = arrive; j < leave; j++) {
                time[j]++;
            }
        }

        int result = 0;

        for (int i = 0; i < time.length; i++) {
            if (time[i] == 1) {
                result += A;
            } else if (time[i] == 2) {
                result += B * 2;
            } else if (time[i] == 3) {
                result += C * 3;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}