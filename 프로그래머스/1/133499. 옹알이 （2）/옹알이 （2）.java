class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];
            if (s.contains("aya")) {
                s = s.replaceAll("aya", "1");
            }
            if (s.contains("ye")) {
                s = s.replaceAll("ye", "2");
            }
            if (s.contains("woo")) {
                s = s.replaceAll("woo", "3");
            }
            if (s.contains("ma")) {
                s = s.replaceAll("ma", "4");
            }
            System.out.println(s);
            String[] str = s.split("");
            boolean isSeqOrCantPron = false;
            for (int j = 0; j < str.length - 1; j++) {
                if (str[j].equals(str[j + 1])) {
                    isSeqOrCantPron = true;
                    break;
                }
                if (Character.isLetter(str[j].charAt(0))) {
                    isSeqOrCantPron = true;
                    break;
                }
            }

            for (int j = 0; j < str.length; j++) {
                if (Character.isLetter(str[j].charAt(0))) {
                    isSeqOrCantPron = true;
                    break;
                }
            }

            if (!isSeqOrCantPron) {
                answer++;
            }
        }

        return answer;
    }
}