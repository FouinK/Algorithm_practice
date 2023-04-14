import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
                
        Set<String> set = new HashSet<>();

                
        int i = 5;
        int j = 5;

        for (int k = 0; k < dirs.length(); k++) {

            String now = String.valueOf(i) + j;

            if (dirs.charAt(i) == 'U') {
                i += 1;

                if (i > 10) {
                    i -=1;
                    continue;
                }

            } else if (dirs.charAt(i) == 'D') {
                i -= 1;

                if (i < -10) {
                    i += 1;
                    continue;
                }

            } else if (dirs.charAt(i) == 'L') {
                j -= 1;

                if (j < -10) {
                    j += 1;
                    continue;
                }

            } else {
                j += 1;

                if (j > 10) {
                    j -= 1;
                    continue;
                }

            }
            StringBuilder sb = new StringBuilder();
            String next = String.valueOf(i) + j;

            set.add(sb.append(now).append(next).toString());

            System.out.println(sb.append(now).append(next));

        }


        return set.size();
    }
}