import java.util.*;

class Solution {
        
    public static int answer = 0;
    public static boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        
        dfs(dungeons, k, 0);

        return answer;
    }
    
    public static void dfs(int[][] dungeons, int piro, int cnt) {
        for (int i=0;i<dungeons.length;i++) {
            if(!visit[i] && dungeons[i][0] <= piro) {
                visit[i] = true;
                dfs(dungeons, piro-dungeons[i][1], cnt+1);
                visit[i] = false;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
    
}