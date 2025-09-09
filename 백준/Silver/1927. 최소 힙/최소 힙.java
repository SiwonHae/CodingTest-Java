import java.io.*;
import java.util.*;

public class Main {
    static int[] heap;
    static int len;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        heap = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (len == 0) {
                    bw.write("0\n");
                } else {
                    bw.write(peek() + "\n");
                    poll();
                }
            } else {
                offer(x);
            }
        }
        
        bw.flush();
    }
    
    public static void offer(int x) {
        heap[++len] = x;
        int idx = len;
        
        while (idx != 1) {
            int parent = idx / 2;
            if (heap[parent] <= heap[idx]) {
                break;
            }
            
            int tmp = heap[parent];
            heap[parent] = heap[idx];
            heap[idx] = tmp;
            
            idx = parent;
        }
    }
    
    public static int peek() {
        if (len == 0) {
            return 0;
        }
        
        return heap[1];
    }
    
    public static void poll() {
        if (len == 1) {
            len--;
            return;
        }
        
        heap[1] = heap[len--];
        int idx = 1;
        
        while (2 * idx <= len) {
            int leftChildIdx = 2 * idx;
            int rightChildIdx = 2 * idx + 1;
            int minChildIdx = leftChildIdx;
            
            if (rightChildIdx <= len && heap[rightChildIdx] < heap[leftChildIdx]) {
                minChildIdx = rightChildIdx;
            }
            
            if (heap[idx] <= heap[minChildIdx]) {
                break;
            }
            
            int tmp = heap[idx];
            heap[idx] = heap[minChildIdx];
            heap[minChildIdx] = tmp;
            
            idx = minChildIdx;
        }
    }
}