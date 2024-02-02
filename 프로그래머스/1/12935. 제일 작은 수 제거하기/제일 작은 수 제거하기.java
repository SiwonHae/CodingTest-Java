class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            }
            answer[index] = arr[i];
            index++;
        }
        
        if (answer.length == 0) {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }
}