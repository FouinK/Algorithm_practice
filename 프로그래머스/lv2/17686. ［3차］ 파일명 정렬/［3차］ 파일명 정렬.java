import java.util.*;

class Solution {
    public String[] solution(String[] files) {
                
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file = detach(o1);
                String[] file2 = detach(o2);

                int headValue = file[0].compareTo(file2[0]);

                if (headValue == 0) {
                    int num1 = Integer.parseInt(file[1]);
                    int num2 = Integer.parseInt(file2[1]);
                    return num1-num2;
                } else {
                    return headValue;
                }
            }
        });

        
        return files;
    }
    
    public String[] detach(String str) {
        StringBuilder head = new StringBuilder("");
        StringBuilder number = new StringBuilder("");
        StringBuilder tail = new StringBuilder("");

        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                break;
            }
            head.append(str.charAt(i));
        }

        for (; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            }
            number.append(str.charAt(i));
        }

        for (; i < str.length(); i++) {
            tail.append(str.charAt(i));
        }

        return new String[]{head.toString().toLowerCase(), number.toString(), tail.toString()};
    }
}