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
            int check = Integer.parseInt(st.nextToken());
            list.add(new Cow(arrive, check));
        }

        Collections.sort(list, (o1, o2) -> {
            return o1.arrive - o2.arrive;
        });

        int result = 0;
        for (int i = 0; i < N; i++) {
            Cow c = list.get(i);
            if (c.arrive > result) {
                result = c.arrive;
            }
            result += c.check;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

class Cow {
    int arrive;
    int check;

    public Cow(int arrive, int check) {
        this.arrive = arrive;
        this.check = check;
    }
}