
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i < str1.length(); i++) {

            String divideWord = str1.substring(i - 1, i + 1);

            if (Character.isAlphabetic(divideWord.charAt(0)) && Character.isAlphabetic(divideWord.charAt(1))) {

                if (map1.containsKey(divideWord)) {
                    map1.put(divideWord, map1.get(divideWord) + 1);
                } else {
                    map1.put(divideWord, 1);
                }

            }

        }

        for (int i = 1; i < str2.length(); i++) {

            String divideWord = str2.substring(i - 1, i + 1);

            if (Character.isAlphabetic(divideWord.charAt(0)) && Character.isAlphabetic(divideWord.charAt(1))) {

                if (map2.containsKey(divideWord)) {
                    map2.put(divideWord, map2.get(divideWord) + 1);
                } else {
                    map2.put(divideWord, 1);
                }

            }

        }

        int kyoutsu = 0;
        int zenbu = 0;

        for (String key : map1.keySet()) {

            if (map2.containsKey(key)) {
                kyoutsu += Math.min(map1.get(key), map2.get(key));
                zenbu += Math.max(map1.get(key), map2.get(key));
            } else {
                zenbu += map1.get(key);
            }

        }

        for (String key : map2.keySet()) {

            if (!map1.containsKey(key)) {
                zenbu += map2.get(key);
            }

        }

        
        if (zenbu == 0) {
            return 65536;
        }
        
        if(kyoutsu == 0) {
            return 0;
        }

        double divide = ((double) kyoutsu /(double) zenbu) * 65536;
        
        return (int) divide;
    }
}