import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] vowel = {"a", "e", "i", "o", "u"};

        String input = "";
        while (!(input = br.readLine()).equals("end")) {

            boolean isVowel = false;
            boolean isSeqVowelOrConsonant = false;
            boolean isSeqSame = false;

            int vowelCnt = 0;
            int consonantCnt = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    isVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    consonantCnt++;
                    vowelCnt = 0;
                }

                if (vowelCnt >= 3 || consonantCnt >= 3) {
                    isSeqVowelOrConsonant = true;
                    break;
                }

                if (i < input.length() - 1) {
                    char c2 = input.charAt(i + 1);
                    if (c == c2) {
                        if (c != 'e' && c != 'o') {
                            isSeqSame = true;
                            break;
                        }
                    }
                }
            }

            bw.write("<" + input + "> is ");
            if (!isVowel || isSeqVowelOrConsonant || isSeqSame) {
                bw.write("not acceptable.\n");
            } else {
                bw.write("acceptable.\n");
            }
        }

        bw.flush();
    }
}