class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int[] answer = new int[2];

        int allDenom = 0;
        int allNumber = 0;

        if (denom1 != denom2) {
            allDenom = denom1 * denom2;
            allNumber = numer1 * denom2 + numer2 * denom1;
        } else {
            allDenom = denom1;
            allNumber = numer1 + numer2;
        }



        while (true) {
            boolean check = false;

            for (int i = allDenom; i > 1; i--) {
                if (allDenom % i == 0 && allNumber % i == 0) {
                    allDenom /= i;
                    allNumber /= i;
                    check = true;
                }
            }

            if (!check) {
                break;
            }
        }

        answer[0] = allNumber;
        answer[1] = allDenom;
        
        return answer;
    }
}