import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
                
        LinkedList<int[]> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            que.offer(new int[]{i, priorities[i]});
        }

        int answer = 0;

        while (!que.isEmpty()) {
            
            int[] poll = que.poll();
            boolean isMax = true;
            for (int i = 0; i < que.size(); i++) {
                if (poll[1] < que.get(i)[1]) {
                    que.offer(poll);

                    for (int j = 0; j < i; j++) {
                        que.offer(que.poll());
                    }

                    isMax = false;
                    break;

                }
            }

            if (!isMax) {
                continue;
            }
            
            answer++;

            if (location == poll[0]) {
                break;
            }
        }
        return answer;
    }
}