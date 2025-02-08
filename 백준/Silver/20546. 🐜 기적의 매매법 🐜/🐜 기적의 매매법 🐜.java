import java.io.*;
import java.util.*;

public class Main {
    static int[] stocks = new int[14];
    static int jCash;
    static int sCash;
    static int jStock;
    static int sStock;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cash = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }
        
        jCash = cash;
        sCash = cash;
        
        bnp();
        timing();

        int jTotal = jCash + (jStock * stocks[13]);
        int sTotal = sCash + (sStock * stocks[13]);
        
        if (jTotal > sTotal) {
            bw.write("BNP");
        } else if (sTotal > jTotal) {
            bw.write("TIMING");
        } else {
            bw.write("SAMESAME");
        }

        bw.flush();
    }
    
    public static void bnp() {
        for (int i = 0; i < 14; i++) {
            if (jCash >= stocks[i]) {
                int buy = jCash / stocks[i];
                jStock += buy;
                jCash -= buy * stocks[i];
            }
        }
    }
    
    public static void timing() {
        int up = 0;
        int down = 0;
        
        for (int i = 1; i < 14; i++) {
            if (stocks[i] > stocks[i - 1]) {
                up++;
                down = 0;
            } else if (stocks[i] < stocks[i - 1]) {
                down++;
                up = 0;
            } else {
                up = 0;
                down = 0;
            }

            if (up >= 3) {
                sCash += sStock * stocks[i];
                sStock = 0;
            }
            
            if (sCash != 0 && down >= 3) {
                int buy = sCash / stocks[i];
                sStock += buy;
                sCash -= buy * stocks[i];
            }

        }
    }
}