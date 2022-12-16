import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);

        for (int i = 2; i <= number; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    set.add(j);
                    set.add(i / j);
                }
            }

            map.put(i, set.size());
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > limit) {
                map.put(key, power);
            }
            answer += map.get(key);
        }
        return answer;
    }
}