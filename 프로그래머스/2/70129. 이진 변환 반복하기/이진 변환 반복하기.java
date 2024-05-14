class Solution {

    private int countZeros(String s) {
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }

        return zeros;
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        int loop = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int zeros = countZeros(s);
            removed += zeros;
            loop++;

            int length = s.length() - zeros;
            s = Integer.toBinaryString(length);
        }


        answer[0] = loop;
        answer[1] = removed;

        return answer;
    }
}