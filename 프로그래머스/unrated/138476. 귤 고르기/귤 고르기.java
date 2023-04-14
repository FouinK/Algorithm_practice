import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
                
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int sum = 0;
        int answer = 0;

        List<Integer> cnts = new ArrayList<>();

        for (Integer key : map.keySet()) {
            cnts.add(map.get(key));
        }

        cnts.sort(Collections.reverseOrder());
        
        for (Integer cnt : cnts) {
            answer++;
            sum += cnt;
            if (sum >= k) {
                break;
            }
        }
        return answer;
    }
}