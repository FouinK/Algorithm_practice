import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        score = Arrays.stream(score)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int answer = 0;
        int cnt = 1;

        for (int i = 0; i < score.length; i++) {
            if (cnt % m == 0) {
                answer += score[i] * m;
            }
            cnt++;
        }
        return answer;
    }
}