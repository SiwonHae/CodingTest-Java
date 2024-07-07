import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int result = n;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int[] arr = new int[26];

            int prev = 0;
            for (int j = 0; j < s.length(); j++) {
                int now = s.charAt(j);

                // 이전에 나온 문자와 현재 문자가 같으면 pass
                if (prev != now) {
                    // 이전에 나온적 없으면
                    if (arr[now - 'a'] == 0) {
                        arr[now - 'a']++;
                        prev = now;
                    } else {
                        result--;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
