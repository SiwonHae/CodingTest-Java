import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        int[] arr = new int[26];

        // 팰린드롬은 홀수개의 문자가 2개 이상 존재하면 만들 수 없다.

        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'A';
            arr[idx]++;
        }

        int oddCnt = 0;
        int middle = 0;
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
