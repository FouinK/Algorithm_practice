import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        int[] answer = new int[2];
        
        List<int[]> arr = new ArrayList<>();

        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) {
                arr.add(new int[]{i, sum / i});
            }
        }

//         for (int i = 0; i < arr.size(); i++) {
//             int[] ints = arr.get(i);
//             System.out.println(ints[0] + " " + ints[1]);
//         }
        
        for (int i = 0; i < arr.size(); i++) {
            int[] ints = arr.get(i);
            if (ints[0] >= ints[1] && ints[0] > 2 && ints[1] > 2) {
                if ((ints[0] - 2) * (ints[1] - 2) == yellow) {
                    answer[0] = ints[0];
                    answer[1] = ints[1];
                    break;
                }
            }
        }
        
        return answer;
    }
}