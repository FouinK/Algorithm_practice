import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
                int[] answer = new int[num_list.length];

        List<Integer> nums = Arrays.stream(num_list).boxed().collect(Collectors.toList());

        Collections.reverse(nums);

        for (int i = 0; i < nums.size(); i++) {
            answer[i] = nums.get(i);
        }
        
        
        return answer;
    }
}