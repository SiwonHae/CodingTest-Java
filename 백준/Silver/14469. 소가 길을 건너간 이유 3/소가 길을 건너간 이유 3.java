import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Cow> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int verify = Integer.parseInt(st.nextToken());
            list.add(new Cow(arrive, verify));
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.arrive - o2.arrive;
        });

        int current = 0;
        for (Cow cow : list) {
            if (current < cow.arrive) {
                current = cow.arrive + cow.verify;
            } else {
                current += cow.verify;
            }
        }

        bw.write(String.valueOf(current));
        bw.flush();
    }

    static class Cow {
        int arrive;
        int verify;

        public Cow(int arrive, int verify) {
            this.arrive = arrive;
            this.verify = verify;
        }
    }
}