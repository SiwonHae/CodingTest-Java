import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        switches = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                male(switchNum);
            } else {
                female(switchNum);
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(switches[i] + " ");

            if (i % 20 == 0) {
                bw.write("\n");
            }
        }

        bw.flush();
    }

    public static void male(int switchNum) {
        for (int i = switchNum; i <= n; i += switchNum) {
            if (i % switchNum == 0) {
                switches[i] ^= 1;
            }
        }
    }

    public static void female(int switchNum) {
        int start = switchNum - 1;
        int end = switchNum + 1;

        switches[switchNum] ^= 1;

        while (start >= 1 && end <= n) {
            if (switches[start] != switches[end]) {
                break;
            } else {
                switches[start] ^= 1;
                switches[end] ^= 1;
                start--;
                end++;
            }
        }
    }
}