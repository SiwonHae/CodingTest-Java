import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();

        // 홀수개의 문자가 2개 이상이면 만들 수 없다.

        int[] arr = new int[26];
        for (int i = 0; i < name.length(); i++) {
            arr[name.charAt(i) - 'A']++;
        }

        int oddCnt = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            int cnt = arr[i];

            if (cnt % 2 != 0) {
                oddCnt++;
                oddChar = (char) (i + 'A');
            }
        }

        if (oddCnt >= 2) {
            bw.write("I'm Sorry Hansoo");
            bw.flush();
            return;
        }

        StringBuilder front = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int cnt = arr[i];

            for (int j = 0; j < cnt / 2; j++) {
                char c = (char) (i + 'A');
                front.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(front);

        String back = front.reverse().toString();

        if (oddChar != 0) {
            result.append(oddChar).append(back);
        } else {
            result.append(back);
        }

        bw.write(result.toString());
        bw.flush();
    }
}