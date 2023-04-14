package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            if (word.equals(".")) {
                System.out.println(sb);
                return ;
            }

            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for (int i = 0; i < word.length(); i++) {

                if (word.charAt(i) == '[' || word.charAt(i) == '(' || word.charAt(i) == ']' || word.charAt(i) == ')') {

                    if (word.charAt(i) == ']') {

                        if (stack.isEmpty()) {
                            check = false;
                            break;
                        } else if(stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(word.charAt(i));
                        }

                    } else if (word.charAt(i) == ')') {

                        if (stack.isEmpty()) {
                            check = false;
                            break;
                        } else if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(word.charAt(i));

                        }

                    } else {

                        stack.push(word.charAt(i));

                    }

                }

            }

            if (!stack.isEmpty()) {
                check = false;
            }

            if (check) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }


    }

}