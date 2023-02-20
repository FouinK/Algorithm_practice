
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;

        for (String skillTree : skill_trees) {

            boolean check = true;
            Queue<Character> queue = new LinkedList<>();

            for (int i = 0; i < skill.length(); i++) {
                queue.offer(skill.charAt(i));
            }

            for (int i = 0; i < skillTree.length(); i++) {
                if (skill.contains(String.valueOf(skillTree.charAt(i)))) {
                    if (queue.peek() != skillTree.charAt(i)) {
                        check = false;
                        break;
                    } else {
                        queue.poll();
                    }
                }
            }

            if (check) {
                answer++;
            }
        }
        
        return answer;
    }
}