class Solution {
    public int[] solution(int num, int total) {
        int middle = total / num;
        int value = middle;
        int sum = 0;
        int cnt = 0;
        while (true) {
            int[] answer = new int[num];
            
            for (int i = 0; i < num; i++) {
                answer[i] = value;
                sum += value;
                value++;
            }
            
            if (sum == total) {
                return answer;
            } else {
                value = middle;
                cnt--;
                value += cnt;
                sum = 0;
            }
        }
    }
}