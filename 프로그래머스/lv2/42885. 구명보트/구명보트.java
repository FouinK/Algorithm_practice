import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        Arrays.sort(people);

        Deque<Integer> deque = new LinkedList<>();

        for (int i = people.length-1; i >= 0; i--) {
            deque.offer(people[i]);
        }


        while (true) {

            if (deque.isEmpty()) {
                return answer;
            }

            if (limit >= deque.peekFirst() + deque.peekLast()) {
                deque.pollFirst();
                deque.pollLast();
                answer++;
                continue;
            }

            deque.pollFirst();
            answer++;
        }
    }
}