class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        int serviceBeverage = n / 10;

        k -= serviceBeverage;

        answer = n * 12000;

        answer += k * 2000;

        return answer;
    }
}