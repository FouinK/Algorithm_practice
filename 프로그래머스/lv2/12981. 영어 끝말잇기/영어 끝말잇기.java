import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int cnt = 1;

        int answer[] = new int[2];
        Set<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();

        set.add(words[0]);
        stack.push(words[0]);

        cnt++;

        int cha = 1;

        for (int i = 1; i < words.length; i++) {
            if (cnt % (n + 1) == 0) {
                cnt = 1;
                cha++;
            }

            if (stack.peek().charAt(stack.peek().length() - 1) != words[i].charAt(0)) {
                answer[0] = cnt;
                answer[1] = cha;
                break;
            }
            if (set.contains(words[i])) {
                answer[0] = cnt;
                answer[1] = cha;
                break;
            }
            
            set.add(words[i]);
            stack.push(words[i]);
            cnt++;
        }

        return answer;
    }
}