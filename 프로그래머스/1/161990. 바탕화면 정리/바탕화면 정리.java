import java.util.*;

class Solution {

    public int distance(int lux, int luy, int rdx, int rdy) {
        return Math.abs(rdx - lux) + Math.abs(rdy - luy);
    }

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int[][] arr = new int[wallpaper.length][wallpaper[0].length()];

        int lux = 100;
        int luy = 100;
        int rdx = 0;
        int rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            // i번째 행
            String[] s = wallpaper[i].split("");

            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("#")) {
                    lux = Math.min(i, lux);
                    luy = Math.min(j, luy);
                    rdx = Math.max(i + 1, rdx);
                    rdy = Math.max(j + 1, rdy);
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;

        return answer;
    }
}