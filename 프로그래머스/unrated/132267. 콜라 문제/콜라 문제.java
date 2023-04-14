class Solution {
    public int solution(int a, int b, int n) {

        int answer = 0;

        while (n > a-1) {
            int i = n / a;          //20 / 3 = 6

            n = n - (a * i) + (((a*i)/a) * b);    //20 - (3*6) + 6

            answer += (((a*i)/a) * b);
        }


        return answer;
    }
}