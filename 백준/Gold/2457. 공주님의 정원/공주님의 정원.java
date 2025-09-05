import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        Flower[] flowers = new Flower[N];;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(getDay(startMonth, startDay), getDay(endMonth, endDay));
        }

        Arrays.sort(flowers, (f1, f2) -> {
            if (f1.start == f2.start) {
                return f2.end - f1.end;
            }
            return f1.start - f2.start;
        });
        
        int start = getDay(3, 1);
        int end = getDay(11, 30);
        
        int current = start;
        int result = 0;
        int idx = 0;
        
        while (current <= end) {
            int maxEnd = current;
            
            while (idx < flowers.length && flowers[idx].start <= current) {
                if (flowers[idx].end > current) {
                    maxEnd = Math.max(maxEnd, flowers[idx].end);
                }
                idx++;
            }
            
            if (maxEnd == current) {
                result = 0;
                break;
            }
            
            current = maxEnd;
            result++;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
    }
    
    public static int getDay(int month, int day) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDay = 0;
        
        for (int i = 1; i < month; i++) {
            totalDay += days[i];
        }
        totalDay += day;
        
        return totalDay;
    }
    
    static class Flower {
        int start;
        int end;
        
        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}