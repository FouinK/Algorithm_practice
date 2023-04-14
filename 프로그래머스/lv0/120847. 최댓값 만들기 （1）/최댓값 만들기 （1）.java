import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {

        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        numbersList.sort(((o1, o2) -> o2 - o1));

        return numbersList.get(0) * numbersList.get(1);
    }
}