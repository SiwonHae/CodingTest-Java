import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int[] a = new int[26];
        int oddCnt = 0;
        char oddChar = 0;

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 != 0) {
                oddCnt++;
                oddChar = (char) (i + 'A');
            }

            if (oddCnt >= 2) {
                bw.write("I'm Sorry Hansoo");
                bw.flush();
                return;
            }
        }

        String result = "";

        StringBuilder front = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                for (int j = 0; j < a[i] / 2; j++) {
                    front.append((char) (i + 'A'));
                }
            }
        }

        if (oddCnt == 0) {
            result = front.toString() + front.reverse().toString();
        } else {
            result = front.toString() + oddChar + front.reverse().toString();
        }

        bw.write(result);
        bw.flush();
    }
}