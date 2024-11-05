import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            int[] alphabetCnt = new int[4]; // A C G T

            for (int j = 0; j < list.size(); j++) {
                char c = list.get(j).charAt(i);

                if (c == 'A') {
                    alphabetCnt[0]++;
                } else if (c == 'C') {
                    alphabetCnt[1]++;
                } else if (c == 'G') {
                    alphabetCnt[2]++;
                } else if (c == 'T') {
                    alphabetCnt[3]++;
                }
            }

            int maxCnt = 0;
            int maxIdx = 0;
            for (int j = 0; j < 4; j++) {
                if (maxCnt < alphabetCnt[j]) {
                    maxCnt = alphabetCnt[j];
                    maxIdx = j;
                } else if (alphabetCnt[j] == maxCnt) {
                    if (j < maxIdx) {
                        maxIdx = j;
                    }
                }
            }

            if (maxIdx == 0) {
                sb.append("A");
            } else if (maxIdx == 1) {
                sb.append("C");
            } else if (maxIdx == 2) {
                sb.append("G");
            } else if (maxIdx == 3) {
                sb.append("T");
            }
        }

        String result = sb.toString();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < M; j++) {
                char c1 = result.charAt(j);
                char c2 = s.charAt(j);

                if (c1 != c2) {
                    cnt++;
                }
            }
        }

        bw.write(result + "\n");
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}