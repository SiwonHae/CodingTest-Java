import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> distance = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            distance.add(Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        List<Long> price = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            price.add(Long.parseLong(st.nextToken()));
        }

        // 기름을 넣을 수 있는 곳은 0 ~ N-1번 까지.
        // 무조건 0번쨰에서 기름을 넣어야 2번째 도시로 넘어갈 수 있음.
        // 현재 주유소의 가격이 다음 주유소의 가격보다 비싸면 최소로만 넣고 다음 도시로 이동하자.
        // 현재 주유소의 가격이 다음 주유소의 가격보다 싸다면 현재 주유소보다 비싼 주유소를 찾을 때 까지의 거리 만큼의 리터를 넣자.

        long min = price.get(0);
        long result = 0;

        for (int i = 0; i < N - 1; i++) {
            result += min * distance.get(i);
            min = Math.min(min, price.get(i + 1));
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}