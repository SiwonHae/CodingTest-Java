import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] pSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pSum[i] = pSum[i - 1] + temp[i - 1];
        }
        
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = K;
        while (right <= N) {
            list.add(pSum[right] - pSum[left]);
            right++;
            left++;
        }
        
        bw.write(String.valueOf(Collections.max(list)));
        bw.flush();
    }
}