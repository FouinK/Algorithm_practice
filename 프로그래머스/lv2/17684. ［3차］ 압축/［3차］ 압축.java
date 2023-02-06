import java.util.*;

class Solution {
    public int[] solution(String msg) {
                Map<String, Integer> map = new LinkedHashMap<>();
        List<Integer> answer = new ArrayList<>();

        char word = 'A';
        int cnt = 1;

        while (word <= 'Z') {
            map.put(String.valueOf(word), cnt);
            word++;
            cnt++;
        }

        cnt -= 1;
        boolean check = false;

        for (int i = 0; i < msg.length(); i++) {

            String key = String.valueOf(msg.charAt(i));

            while (map.containsKey(key)) {
                i++;
                if (i == msg.length()) {
                    check = true;
                    break;
                }

                key += msg.charAt(i);
            }

            if (check) {
                answer.add(map.get(key));
                break;
            }

            answer.add(map.get(key.substring(0, key.length() - 1)));
            map.put(key, ++cnt);
            i--;
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;

    }
}