import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {

        PriorityQueue<Integer> que = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            if (que.size() < k) {
                que.offer(score[i]);
            } else {
                if (que.peek() < score[i]) {
                    que.poll();
                    que.add(score[i]);
                }
            }

            answer[i] = que.peek();
        }

        return answer;
    }
}