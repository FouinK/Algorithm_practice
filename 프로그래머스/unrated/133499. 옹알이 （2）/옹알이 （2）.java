import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
		for (int i = 0; i < babbling.length; i++) {

			if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")){
				continue;
			}

			if (babbling[i].contains("aya")) {
				babbling[i] = babbling[i].replace("aya", "0");
			}
			if (babbling[i].contains("ye")) {
				babbling[i] = babbling[i].replace("ye", "0");
			}
			if (babbling[i].contains("woo")) {
				babbling[i] = babbling[i].replace("woo", "0");
			}
			if (babbling[i].contains("ma")) {
				babbling[i] = babbling[i].replace("ma", "0");
			}

			if (babbling[i].matches("^[0-9]*$")) {
				answer++;
			}
		}
        return answer;
    }
}