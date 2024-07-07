import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = br.readLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        int cnt = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int idx = s.indexOf(c);
            if (arr[cnt] == -1) {
                arr[cnt] = idx;
            }
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
