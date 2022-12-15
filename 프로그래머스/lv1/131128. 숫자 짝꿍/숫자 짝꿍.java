import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            if (xMap.containsKey(X.charAt(i) - 48)) {
                xMap.put(X.charAt(i) - 48, xMap.get(X.charAt(i) - 48) + 1);
            } else {
                xMap.put(X.charAt(i) - 48, 1);
            }
        }

        for (int i = 0; i < Y.length(); i++) {
            if (yMap.containsKey(Y.charAt(i) - 48)) {
                yMap.put(Y.charAt(i) - 48, yMap.get(Y.charAt(i) - 48) + 1);
            } else {
                yMap.put(Y.charAt(i) - 48, 1);
            }
        }

        for (Integer key : yMap.keySet()) {
            if (xMap.containsKey(key)) {
                int length = Math.min(xMap.get(key), yMap.get(key));
                for (int i = 0; i < length; i++) {
                    list.add(key);
                }
            }
        }

        list.sort((o1, o2) -> o2 - o1);

        if (list.isEmpty()) {
            return "-1";
        }

        if (list.get(0) == 0) {
            return "0";
        }

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }
            
        return String.valueOf(answer);
    }
}