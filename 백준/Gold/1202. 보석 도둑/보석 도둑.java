import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> list = new ArrayList<>();
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list.add(new Jewel(M, V));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }

            return o1.weight - o2.weight;
        });

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            bag[i] = C;
        }

        Arrays.sort(bag);

        // 무게가 가벼운 가방부터 보석을 담자.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int jewelIdx = 0;

        for (int i = 0; i < K; i++) {
            // 현재 가방에 넣을 수 있는 모든 보석을 우선순위 큐에 추가
            while (jewelIdx < N && list.get(jewelIdx).weight <= bag[i]) {
                pq.add(list.get(jewelIdx).price);
                jewelIdx++;
            }
            // 가장 비싼 보석을 선택
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

class Jewel {
    int weight;
    int price;

    public Jewel(int w, int p) {
        this.weight = w;
        this.price = p;
    }
}