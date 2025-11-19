import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int start = 0;
            int end = N - 1;
            
            while (start < end) {
                int sum = arr[start] + arr[end];
                
                if (sum == target) {
                    if (start != i && end != i) {
                        result++;
                        break;
                    }
                    
                    if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        bw.write(result + "");
        bw.flush();
    }
}