class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        char[] str = new_id.toCharArray();
        new_id = "";
        for (int i = 0 ; i < str.length; i++) {
            char c = str[i];
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.') {
                new_id += c;
            }
        }

        // 3단계
        String[] s = new_id.split("");
        new_id = "";
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(".")) {
                int idx = i + 1;
                while (idx < s.length && s[idx].equals(".")) {
                    idx++;
                }
                i = idx - 1;
                new_id += ".";
            } else {
                new_id += s[i];
            }
        }

        // 4단계
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        } else if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5단계
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 7단계
        if (new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);
            while (new_id.length() != 3) {
                new_id += c;
            }
        }
        
        answer = new_id;

        return answer;
    }
}