import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int result[] = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {

            int remainderDay = 100 - progresses[i];

            if (remainderDay % speeds[i] == 0) {
                result[i] = remainderDay / speeds[i];
            } else {
                result[i] = remainderDay / speeds[i] + 1;
            }

            if (i > 0 && result[i - 1] > result[i]) {
                result[i] = result[i - 1];
            }

        }

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int key : result) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        int[] answer = new int[map.size()];

        int i = 0;

        for (Integer key : map.keySet()) {
            answer[i] = map.get(key);
            i++;
        }
        
        return answer;
    }
}