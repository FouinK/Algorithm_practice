import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, LocalTime> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String record : records) {

            String[] split = record.split(" ");

            if (split[2].equals("IN")) {

                LocalTime localTime = LocalTime.parse(split[0]);

                map.put(split[1], localTime);

            } else if(split[2].equals("OUT")) {

                LocalTime localTime = map.get(split[1]);

                long until = localTime.until(LocalTime.parse(split[0]), ChronoUnit.MINUTES);

                map.remove(split[1]);

                if (result.containsKey(split[1])) {
                    result.put(split[1], (int) (result.get(split[1]) + until));
                } else {
                    result.put(split[1], (int) until);
                }

            }

        }

        for (String key : map.keySet()) {
            long until = map.get(key).until(LocalTime.parse("23:59"), ChronoUnit.MINUTES);

            if (result.containsKey(key)) {
                result.put(key, (int) (result.get(key) + until));
            } else {
                result.put(key, (int) until);
            }
        }

        int[] answer = new int[result.size()];
        int i=0;

        TreeMap<String, Integer> tm = new TreeMap<>(result);
        
        for (String key : tm.keySet()) {

            if (result.get(key) <= fees[0]) {


                answer[i] = fees[1];
            } else {

                double divide = (double) (result.get(key) - fees[0]) / fees[2];

                double ceil = Math.ceil(divide);


                int fee = fees[1] + (int) ceil * fees[3];

                answer[i] = fee;
            }


            i++;
        }


        return answer;

    }
}