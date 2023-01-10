class Solution {
    public int[] solution(String s) {

        int zeroCnt = 0;
        int cnt = 0;
        while (!s.equals("1")) {

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                }
            }

            String replace = s.replace("0", "");


            int replaceInt = replace.length();

            String word = "";

            while (replaceInt != 0) {
                int namuzi = replaceInt % 2;
                replaceInt /= 2;
                word = namuzi + word;

            }

            s = word;
            cnt++;
        }

        int[] answer = {cnt, zeroCnt};
        return answer;
    }
}