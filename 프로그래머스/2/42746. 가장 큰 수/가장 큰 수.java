import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        List<String> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(String.valueOf(i));
        }
        
        Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (list.get(0).equals("0")) {
            return "0";
        }
        
        for (String s : list) {
            sb.append(s);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}