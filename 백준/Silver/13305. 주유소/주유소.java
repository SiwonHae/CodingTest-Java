import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> distance = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            distance.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            price.add(Integer.parseInt(st.nextToken()));
        }

        // 기름을 넣을 수 있는 곳은 0 ~ N-1번 까지.
        // 무조건 0번쨰에서 기름을 넣어야 2번째 도시로 넘어갈 수 있음.

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            int distanceIdx = i;

            // 현재 주유소의 가격이 다음 주유소의 가격보다 비싸면 최소로만 넣고 다음 도시로 이동하자.
            if (price.get(i) > price.get(i + 1)) {
                result += price.get(i) * distance.get(i);
            } else {
                // 현재 주유소의 가격이 다음 주유소의 가격보다 싸다면 현재 주유소보다 비싼 주유소를 찾을 때 까지의 거리 만큼의 리터를 넣자.
                int sumDistance = 0;
                for (int j = i; j < N - 1; j++) {
                    if (price.get(i) > price.get(j)) {
                        break;
                    }
                    sumDistance += distance.get(j);
                    distanceIdx++;
                }
                result += price.get(i) * sumDistance;
                i = distanceIdx;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}