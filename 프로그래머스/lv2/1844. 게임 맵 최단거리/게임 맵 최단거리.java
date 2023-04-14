import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visit = new boolean[maps.length][maps[0].length];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int col = poll[0];
            int row = poll[1];

            for (int i = 0; i < 4; i++) {
                int colx = col + dx[i];
                int rowy = row + dy[i];

                if (colx >= 0 && colx < maps.length && rowy >= 0 && rowy < maps[0].length && !visit[colx][rowy] && maps[colx][rowy] >= 1) {
                    maps[colx][rowy] += maps[col][row];
                    visit[colx][rowy] = true;
                    queue.offer(new int[]{colx, rowy});
                }
            }

        }
        
                
        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        }

        return maps[maps.length - 1][maps[0].length - 1];
    }
}