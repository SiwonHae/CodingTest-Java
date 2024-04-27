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
        // [3, 30, 34, 5, 9]
        // "330"과 "303"을 비교하면 "330303"이 "303330"보다 크므로 "3"이 "30"보다 앞에 위치합니다.
        // 그 다음 "3034"와 "3430"을 비교하면 "30343430"이 "34303034"보다 크므로 "34"가 "30"보다 앞에 위치합니다.
        // "3435"와 "5334"를 비교하면 "34355334"이 "53343435"보다 크므로 "5"가 "34"보다 앞에 위치합니다.
        // 마지막으로 "5349"와 "9534"를 비교하면 "53499534"이 "95345349"보다 크므로 "9"가 "5"보다 앞에 위치합니다.
        // 최종적으로 정렬된 배열은 ["3", "30", "34", "5", "9"]에서 ["9", "5", "34", "3", "30"]이 됩니다.
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
