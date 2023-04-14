import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {

            Map<String, Integer> mapInFor = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                
                if (j == discount.length) {
                    break;
                }
                
                mapInFor.put(discount[j], mapInFor.getOrDefault(discount[j], 0) + 1);


            }

            boolean check = true;

            for (String key : map.keySet()) {

                if (!mapInFor.containsKey(key)) {
                    check = false;
                    break;
                }

                if (map.get(key) > mapInFor.get(key)) {
                    check = false;
                    break;
                }

            }

            if (check) {
                answer++;
            }

        }

        return answer;
    }
}