class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String[] expr = my_string.split(" ");

        answer += Integer.parseInt(expr[0]);
        
        for (int i = 1; i < expr.length; i++) {
            if (expr[i].equals("+")) {
                answer += Integer.parseInt(expr[i + 1]);
            } else if (expr[i].equals("-")) {
                answer -= Integer.parseInt(expr[i + 1]);
            }
        }

        return answer;
    }
}