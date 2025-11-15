import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        double M = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] score = new double[N];
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
            M = Math.max(M, score[i]);
        }
        
        double sum = 0;
        for (int i = 0; i < N; i++) {
            score[i] = score[i] / M * 100;
            sum += score[i];
        }
         
        bw.write((double) (sum / N) + "");
        bw.flush();
    }
}