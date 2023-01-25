import java.util.Stack;

class Solution {
    public int solution(String s) {

        int size = s.length();
        int answer = 0;
        int i = 0;

        for (int j = 0; j < size; j++) {
            s = lotation(s);

            if (check(s)) {
                answer++;
            }
        }

        return answer;
    }
    
    public String lotation(String s) {
        return s.substring(1) + s.charAt(0);
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {

                stack.push(s.charAt(i));

            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                if (s.charAt(i) == ']') {

                    if (stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                } else if (s.charAt(i) == '}') {

                    if (stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();

                } else if (s.charAt(i) == ')') {

                    if (stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();

                }
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}