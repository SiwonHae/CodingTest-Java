import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[9];
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        int a = 0;
        int b = 0;
        boolean flags = false;
        
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    a = arr[i];
                    b = arr[j];
                    flags = true;
                    break;
                }
            }
            
            if (flags) {
                break;
            }
        }
        
        int[] result = new int[7];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (arr[i] == a || arr[i] == b) {
                continue;
            } else {
                result[idx++] = arr[i];
            }
        }
        
        Arrays.sort(result);
        for (int i = 0; i < 7; i++) {
            bw.write(result[i] + "\n");
        }
        
        bw.flush();
    }
}
