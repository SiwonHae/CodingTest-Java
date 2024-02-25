class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;

        String[] str = s.split("");

        for (int i = 1; i < s.length(); i++) {
            if (s.substring(0, i).contains(str[i])) {
                StringBuffer sbf = new StringBuffer(s.substring(0, i));
                String reverse = sbf.reverse().toString();

                int index = 0;
                while (reverse.charAt(index) != str[i].charAt(0)) {
                    index++;
                }
                
                answer[i] = index + 1;
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}