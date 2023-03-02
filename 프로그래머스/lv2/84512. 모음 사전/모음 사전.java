import java.util.TreeMap;

class Solution {
    public int solution(String word) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        String[] words = {"A", "E", "I", "O", "U"};

        inputMap("", 0, tm, words);

        int answer = 1;
        
        for (String key : tm.keySet()) {
            if (key.equals(word)) {
                break;
            }
            answer++;
        }
        return answer;
    }
    
    public void inputMap(String str, int depth, TreeMap<String, Integer> tm, String[] words) {

        if (depth == 5) {
            return ;
        }

        for (int i = 0; i < 5; i++) {
            tm.put(str + words[i], 0);
            inputMap(str + words[i], depth + 1, tm, words);
        }
    }
}