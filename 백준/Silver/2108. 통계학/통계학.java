import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] cnt = new int[8001];
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cnt[arr[i] + 4000]++;
        }
        
        bw.write(Math.round((float)sum / N) + "\n");
        
        Arrays.sort(arr);
        bw.write(arr[N / 2] + "\n");
        
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            max = Math.max(max, cnt[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (cnt[i] == max) {
                list.add(i - 4000);
            }
        }
        
        if (list.size() > 1) {
            bw.write(list.get(1) + "\n");
        } else {
            bw.write(list.get(0) + "\n");
        }
        
        bw.write((arr[N - 1] - arr[0]) + "\n");
        
        bw.flush();
    }
}