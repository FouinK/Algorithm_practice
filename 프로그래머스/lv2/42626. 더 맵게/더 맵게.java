import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
                
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::add);

        int answer = 0;

        while (queue.peek() < K) {
            
            if(queue.size() == 1) {
                return -1;
            }
            
            Integer leastScoville = queue.poll();
            Integer secondScoville = queue.poll();

            queue.offer(leastScoville + (secondScoville * 2));
            answer++;
        }

        return answer;
    }
}