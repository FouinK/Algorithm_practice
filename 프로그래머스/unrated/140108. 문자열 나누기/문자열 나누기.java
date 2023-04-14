import java.util.*;
class Solution {
    public int solution(String s) {
        List<Character> equal = new ArrayList<>();
		List<Character> different = new ArrayList<>();

		int answer = 0;

		boolean reset = true;

		for (int i = 0; i < s.length(); i++) {

			if (reset) {
                if (i == s.length() - 1) {
					answer++;
				}
				equal.add(s.charAt(i));
				reset = false;
				continue;
			}

			if (equal.contains(s.charAt(i))) {
				equal.add(s.charAt(i));
			} else {
				different.add(s.charAt(i));
			}

			if (different.size() == equal.size()) {
				answer++;
				equal.clear();
				different.clear();
				reset = true;
			} else if(i == s.length() - 1){
                answer++;
            }

		}
        
        return answer;
    }
}