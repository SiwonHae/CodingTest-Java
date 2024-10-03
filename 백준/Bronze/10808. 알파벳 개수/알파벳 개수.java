import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a']++;
        }

        for (int i : arr) {
            bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
    }
}