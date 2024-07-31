import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int score1 = 0;
        int score2 = 0;

        int lastTime = 0;

        int leadTime1 = 0;
        int leadTime2 = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            String inputTime = st.nextToken();

            int min = Integer.parseInt(inputTime.split(":")[0]);
            int sec = Integer.parseInt(inputTime.split(":")[1]);
            int time = min * 60 + sec;

            if (score1 > score2) {
                leadTime1 += time - lastTime;
            } else if (score2 > score1) {
                leadTime2 += time - lastTime;
            }

            if (team == 1) {
                score1++;
            } else {
                score2++;
            }

            lastTime = time;
        }

        int endTime = 48 * 60;

        if (score1 > score2) {
            leadTime1 += endTime - lastTime;
        } else if (score2 > score1) {
            leadTime2 += endTime - lastTime;
        }

        bw.write(print(leadTime1) + "\n");
        bw.write(print(leadTime2) + "\n");

        bw.flush();
    }

    public static String print(int sec) {
        int min = sec / 60;
        int second = sec % 60;
        return String.format("%02d:%02d", min, second);
    }
}
