class Solution {
    public String solution(String s) {
        String answer = "";

        String[] splitStr = s.split("");
        int cnt = 0;
        for (int i = 0; i < splitStr.length; i++) {
            String str = splitStr[i].toLowerCase();
            
            if (!str.equals(" ")) {
                if (cnt == 0) {
                    answer += str.toUpperCase();
                    cnt++;
                } else {
                    answer += str;
                }
            } else {
                cnt = 0;
                answer += " ";
            }
        }

        return answer;
    }
}