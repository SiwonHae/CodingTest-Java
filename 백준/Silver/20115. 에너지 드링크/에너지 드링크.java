import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 제일 양이 많은 드링크에 제일 양이 적은 드링크의 절반을 넣자.
        Collections.sort(list, Collections.reverseOrder());

        double result = list.get(0);
        for (int i = 1; i < N; i++) {
            result += (double) list.get(i) / 2;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}