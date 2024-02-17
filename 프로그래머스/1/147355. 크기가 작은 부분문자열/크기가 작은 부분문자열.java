class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        long target = Long.parseLong(p);
        int num = p.length();
        int index = num;
        for (int i = 0; i < t.length(); i++) {
            if (i == t.length() - num + 1) {
                break;
            }

            String s = t.substring(i, index);
            index++;

            long n = Long.parseLong(s);

            if (n <= target) {
                answer++;
            }

        }

        return answer;
    }

}