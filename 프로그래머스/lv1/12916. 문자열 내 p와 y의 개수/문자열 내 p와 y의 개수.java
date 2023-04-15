import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s = s.toUpperCase();
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) == 'P' || s.charAt(i) == 'Y') {
                map.put(String.valueOf(s.charAt(i)), map.getOrDefault(String.valueOf(s.charAt(i)) ,0)+1);
            }            
        }
        
        if(map.get("P") == map.get("Y")) {
            return true;
        } else {
            return false;
        }

    }
}