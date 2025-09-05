import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int zeroCnt = 0;
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num >= 1) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(num);
            } else {
                zeroCnt++;
            }
        }
        
        Collections.sort(positives, Collections.reverseOrder());
        Collections.sort(negatives);

        int result = 0;
        
        for (int i = 0; i < positives.size(); i++) {
            if (i + 1 < positives.size() && positives.get(i) > 1 && positives.get(i + 1) > 1) {
                result += positives.get(i) * positives.get(i + 1);
                i++;
            } else {
                result += positives.get(i);
            }
        }
        
        for (int i = 0; i < negatives.size(); i++) {
            if (i + 1 < negatives.size()) {
                result += negatives.get(i) * negatives.get(i + 1);
                i++;
            } else {
                if (zeroCnt == 0) {
                    result += negatives.get(i);
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}