class Solution {
    public int[] solution(long n) {
        
        String num = String.valueOf(n);
        char[] number = num.toCharArray();

        int[] answer = new int[number.length];

        System.out.println(number.toString());
        
        int index = number.length - 1;
        for (int i = 0; i < number.length; i++) {
            answer[i] = number[index] - '0';
            index--;
        }
        
        return answer;
    }
}