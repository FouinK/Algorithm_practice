import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
		Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {

			if (stack.size() < 3) {
				stack.push(ingredient[i]);
				continue;
			} else {
				int pop1 = stack.pop();
				int pop2 = stack.pop();
				if(ingredient[i] == 1 && pop1 == 3 && pop2 == 2 &&stack.peek() == 1) {
					answer++;
					stack.pop();
				} else {
					stack.push(pop2);
					stack.push(pop1);
					stack.push(ingredient[i]);
				}
			}
		}
        return answer;
    }
}   