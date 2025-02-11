import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] duck = {'q', 'u', 'a', 'c', 'k'};

        char[] arr = br.readLine().toCharArray();
        if (arr[0] != 'q' || arr.length % 5 != 0) {
            bw.write("-1");
            bw.flush();
            return;
        }

        boolean[] visited = new boolean[arr.length];
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'q' && !visited[i]) {
                int idx = 0;

                for (int j = i; j < arr.length; j++) {
                    if (arr[j] == duck[idx] && !visited[j]) {
                        visited[j] = true;
                        idx++;

                        if (idx == 5) {
                            idx = 0;
                        }
                    }
                }

                if (idx != 0) {
                    bw.write("-1");
                    bw.flush();
                    return;
                }

                result++;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bw.write("-1");
                bw.flush();
                return;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}