import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        arr = new int[5][5];
        
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        for (int k = 0; k < 25; k++) {
            int num = list.get(k);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] == num) {
                        arr[i][j] = 0;
                        break;
                    }
                }
            }

            if (check()) {
                bw.write(String.valueOf(k + 1));
                bw.flush();
                return;
            }
        }
    }
    
    public static boolean check() {
        int result = 0;
        int check = 0;
        
        for (int i = 0; i < 5; i++) {
            if (isRow(i)) {
                result++;
            }
            if (isColumn(i)) {
                result++;
            }
        }
        
        if (isRightDiagonal()) {
            result++;
        }

        if (isLeftDiagonal()) {
            result++;
        }

        return result >= 3;
    }

    public static boolean isRow(int row) {
        for (int j = 0; j < 5; j++) {
            if (arr[row][j] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isColumn(int column) {
        for (int i = 0; i < 5; i++) {
            if (arr[i][column] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRightDiagonal() {
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLeftDiagonal() {
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] != 0) {
                return false;
            }
        }
        return true;
    }
}