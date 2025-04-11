import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static List<String> words = new ArrayList<>();
    static boolean[] visited = new boolean[26];
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 기본적으로 a n t i c 는 읽을 수 있어야함.
        if (K < 5) {
            bw.write("0");
            bw.flush();
            return;
        }

        if (K == 26) {
            bw.write(String.valueOf(N));
            bw.flush();
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String word = input.substring(4, input.length() - 4);
            words.add(word);
        }

        backtrack(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void backtrack(int index, int depth) {
        if (depth == K - 5) {
            int cnt = 0;

            for (String word : words) {
                boolean flag = true;
                for (char c : word.toCharArray()) {
                    if (!visited[c - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                }
            }

            result = Math.max(result, cnt);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}