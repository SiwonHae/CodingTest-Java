import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 총 게임 시간 48:00
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int endTime = 48 * 60;
        
        int oneTime = 0;
        int twoTime = 0;
        
        int oneScore = 0;
        int twoScore = 0;
        
        int changeTime = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            
            int min = Integer.parseInt(time[0]);
            int sec = Integer.parseInt(time[1]);
            
            int total = min * 60 + sec;
           
            if (oneScore > twoScore) {
                oneTime += total - changeTime;
            } else if (oneScore < twoScore) {
                twoTime += total - changeTime;
            }
            
            if (team == 1) {
                oneScore++;
            } else {
                twoScore++;
            }
            
            changeTime = total;
            
        }
        
        if (oneScore > twoScore) {
            oneTime += endTime - changeTime;
        } else if (oneScore < twoScore) {
            twoTime += endTime - changeTime;
        }
        
        int oneMin = oneTime / 60;
        int oneSec = oneTime % 60;
        int twoMin = twoTime / 60;
        int twoSec = twoTime % 60;
        bw.write(String.format("%02d:%02d\n", oneMin, oneSec));
        bw.write(String.format("%02d:%02d\n", twoMin, twoSec));

        bw.flush();
    }
}