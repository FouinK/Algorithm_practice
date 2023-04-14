import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0;i<array.length;i++){
            if(n == array[i]){
                map.put(array[i], map.getOrDefault(array[i], 0)+1);    
            }
            
        }
        
        if(map.containsKey(n)){
            return map.get(n);
        } 
        
        return 0;
    }
}