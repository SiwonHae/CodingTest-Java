import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String answer = "";
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // o1과 o2를 비교하는데 있어
        // o1 + o2가 더 큰지, o2 + o1이 더 큰지 비교한다.
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for (String s : str) {
            answer += s;
        }
        
        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }
}