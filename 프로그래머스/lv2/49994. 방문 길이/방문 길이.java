import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
                
        Set<String> set = new HashSet<>();

        int i = 5;
        int j = 5;

        for (int k = 0; k < dirs.length(); k++) {

            String now = String.valueOf(i) + j;

            if (dirs.charAt(k) == 'U') {

                if (i == 10) {
                    continue;
                }

                i++;

            } else if (dirs.charAt(k) == 'D') {

                if (i == 0) {
                    continue;
                }

                i--;

            } else if (dirs.charAt(k) == 'L') {

                if (j == 0) {
                    continue;
                }

                j--;

            } else {

                if (j == 10) {
                    continue;

                }

                j++;

            }

            StringBuilder sb = new StringBuilder();
            String next = String.valueOf(i) + j;

            set.add(sb.append(now).append(next).toString());
            
            StringBuilder reverseSb = new StringBuilder();
            set.add(reverseSb.append(next).append(now).toString());
            // System.out.println(sb);
        }


        return set.size() / 2;
    }
}