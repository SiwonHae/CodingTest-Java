import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String name = br.readLine();

        int[] arr = new int[26];
        int oddCnt = 0;
        int middle = 0;
        // 홀수인 알파벳이 2개 이상이면 펠린드롬 불가.
        // 홀수인 알파벳이 중간에 들어가야 펠린드롬이 된다.

        for (int i = 0; i < name.length(); i++) {
            arr[name.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                oddCnt++;
                middle = i;
            }
        }

        if (oddCnt >= 2) {
            bw.write("I'm Sorry Hansoo");
            bw.flush();
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String front = sb.toString();

        if (oddCnt == 1) {
            front += (char) (middle + 'A');
        }

        String back = sb.reverse().toString();

        bw.write(front + back);
        bw.flush();
    }
}
