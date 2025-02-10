import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Point> consonant = new HashMap<>();
    static Map<Character, Point> vowel = new HashMap<>();

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char left = st.nextToken().charAt(0);
        char right = st.nextToken().charAt(0);

        String input = br.readLine();

        init();

        int time = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            Point a;
            Point b;

            if (consonant.containsKey(c)) {
                a = consonant.get(left);
                b = consonant.get(c);
                left = c;
            } else if (vowel.containsKey(c)) {
                a = vowel.get(right);
                b = vowel.get(c);
                right = c;
            } else {
                continue;
            }

            time += Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
            time++;
        }

        bw.write(String.valueOf(time));
        bw.flush();
    }

    public static void init() {
        consonant.put('q', new Point(0, 0));
        consonant.put('w', new Point(0, 1));
        consonant.put('e', new Point(0, 2));
        consonant.put('r', new Point(0, 3));
        consonant.put('t', new Point(0, 4));
        consonant.put('a', new Point(1, 0));
        consonant.put('s', new Point(1, 1));
        consonant.put('d', new Point(1, 2));
        consonant.put('f', new Point(1, 3));
        consonant.put('g', new Point(1, 4));
        consonant.put('z', new Point(2, 0));
        consonant.put('x', new Point(2, 1));
        consonant.put('c', new Point(2, 2));
        consonant.put('v', new Point(2, 3));

        vowel.put('y', new Point(0, 5));
        vowel.put('u', new Point(0, 6));
        vowel.put('i', new Point(0, 7));
        vowel.put('o', new Point(0, 8));
        vowel.put('p', new Point(0, 9));
        vowel.put('h', new Point(1, 5));
        vowel.put('j', new Point(1, 6));
        vowel.put('k', new Point(1, 7));
        vowel.put('l', new Point(1, 8));
        vowel.put('b', new Point(2, 4));
        vowel.put('n', new Point(2, 5));
        vowel.put('m', new Point(2, 6));
    }
}