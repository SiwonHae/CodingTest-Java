import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);
        
        int except = Math.round(n / 100.0f * 15);
        
        int sum = 0;
        for (int i = except; i < n - except; i++) {
            sum += score[i];
        }
        
        bw.write(Math.round(sum / (float)(n - except * 2)) + "");
        bw.flush();
    }
}