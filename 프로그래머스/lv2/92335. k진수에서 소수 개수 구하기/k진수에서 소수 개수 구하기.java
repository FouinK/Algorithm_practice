class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }

        String result = sb.reverse().toString();

        String[] split = result.split("0");

        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }
    
    public boolean isPrime(Long num) {
        
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}