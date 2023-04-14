class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        while (max != min) {

            if (min % 2 != 0) {
                min++;
            }
            min /= 2;

            if (max % 2 != 0) {
                max++;
            }
            max /= 2;

            answer++;
        }

        return answer;
    }
}