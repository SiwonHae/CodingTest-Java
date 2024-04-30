import java.util.*;

class Solution {

    public String[] splitFile(String file) {

        file = file.toLowerCase();

        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length());
        
        String[] fileInfo = {head, number};

        return fileInfo;
    }

    public String validNumber(String number) {
        String validNum = "";
        char[] c = number.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i]) && validNum.length() <= 5) {
                validNum += c[i];
            } else {
                return validNum;
            }
        }

        return validNum;
    }

    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = splitFile(o1);
                String[] file2 = splitFile(o2);

                int result = file1[0].compareTo(file2[0]);

                // HEAD가 같다면 NUMBER로 정렬
                if (result == 0) {
                    int number1 = Integer.parseInt(validNumber((file1[1])));
                    int number2 = Integer.parseInt(validNumber((file2[1])));
                    return number1 - number2;
                }
                return result;
            }
        });

        return files;
    }
}