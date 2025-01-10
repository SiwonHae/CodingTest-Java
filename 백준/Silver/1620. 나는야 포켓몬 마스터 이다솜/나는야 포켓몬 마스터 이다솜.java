import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToIdx = new HashMap<>();
        Map<Integer, String> IdxToName = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            nameToIdx.put(name, i + 1);
            IdxToName.put(i + 1, name);
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();

            if (Character.isDigit(problem.charAt(0))) {
                bw.write(IdxToName.get(Integer.parseInt(problem)) + "\n");
            } else {
                bw.write(nameToIdx.get(problem) + "\n");
            }
        }

        bw.flush();
    }
}