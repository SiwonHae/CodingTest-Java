class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            String binaryMap1 = Integer.toBinaryString(arr1[i]);
            String binaryMap2 = Integer.toBinaryString(arr2[i]);
            while (binaryMap1.length() != n) {
                binaryMap1 = "0" + binaryMap1;
            }
            while (binaryMap2.length() != n) {
                binaryMap2 = "0" + binaryMap2;
            }

            String line = "";
            for (int j = 0; j < n; j++) {
                if (binaryMap1.charAt(j) == '1' || binaryMap2.charAt(j) == '1') {
                    line += "#";
                } else {
                    line += " ";
                }
            }
            answer[i] = line;
        }

        return answer;
    }
}