import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            a[name.charAt(0) - 'a']++;
        }

        boolean flags = false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 5) {
                flags = true;
                bw.write((char) (i + 'a'));
            }
        }

        if (!flags) {
            bw.write("PREDAJA");
        }

        bw.flush();
    }
}