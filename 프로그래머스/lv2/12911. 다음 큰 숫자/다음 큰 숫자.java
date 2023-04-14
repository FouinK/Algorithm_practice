class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int cnt = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                cnt++;
            }
        }

        while (true) {
            int cntInWhile = 0;
            n++;

            String nextBinary = Integer.toBinaryString(n);

            for (int i = 0; i < nextBinary.length(); i++) {
                if (nextBinary.charAt(i) == '1') {
                    cntInWhile++;
                }
            }


            if (cnt == cntInWhile) {
                break;
            }
        }

        return n;
    }
}