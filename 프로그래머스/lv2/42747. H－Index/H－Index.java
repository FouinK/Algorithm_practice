import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        
        List<Integer> getCitations = Arrays.stream(citations).boxed().collect(Collectors.toList());

        Collections.sort(getCitations, (o1, o2) -> o2 - o1);

        int[] hIdx = new int[getCitations.size()];

        for (int i = 0; i < hIdx.length; i++) {
            hIdx[i] = i + 1;
        }

        int answer = 0;
        
        for (int i = 0; i < getCitations.size(); i++) {
            if (getCitations.get(i) >= hIdx[i]) {
                answer = hIdx[i];
            }
        }

        System.out.println(answer);
        return answer;
    }
}