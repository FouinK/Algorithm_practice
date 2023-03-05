import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
             
        Queue<Integer> queue = new LinkedList<>();

        int i = 0;
        int bridge_weight = 0;
        int time = 0;

        while (true) {

            if (i == truck_weights.length) {
                break;
            }

            if (queue.size() == bridge_length) {
                bridge_weight -= queue.poll();
            }

            if (weight < bridge_weight + truck_weights[i]) {
                queue.offer(0);
                time++;
                continue;
            }

            queue.offer(truck_weights[i]);
            bridge_weight += truck_weights[i];
            time++;
            i++;
        }
        
        return time + bridge_length;
    }
}