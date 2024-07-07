import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb);
    }
}
