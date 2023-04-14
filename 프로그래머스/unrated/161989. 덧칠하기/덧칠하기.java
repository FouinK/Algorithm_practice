class Solution {
    public int solution(int n, int m, int[] section) {

        int answer = 0;
        boolean[] visit = new boolean[section.length];

        for (int i = 0; i < section.length; i++) {
            if (visit[i]) {
                continue;
            }

            if (i == section.length - 1) {
                answer++;
                break;
            }

            int value = section[i] + m - 1;

            int idx = i;

            while (true) {
                if (section[idx] > value) {
                    break;
                }
                
                if (idx == section.length - 1) {
                    if(section[idx] <= value) {
                        visit[idx] = true;
                    }
                    break;
                }

                visit[idx] = true;
                idx++;

            }

            answer++;
        }
        System.out.println(answer);
        
        return answer;
    }
}