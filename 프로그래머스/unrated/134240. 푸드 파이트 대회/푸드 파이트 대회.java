import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i] -=1;
            }
            for (int j = 0; j < food[i] / 2; j++) {
                first.add(i);
                second.add(i);
            }
        }

        Collections.sort(second, (o1, o2) -> o2 - o1);

        first.add(0);

        first.addAll(second);

        for (int i = 0; i < first.size(); i++) {
            sb.append(first.get(i));
        }

        return String.valueOf(sb);
    }
}