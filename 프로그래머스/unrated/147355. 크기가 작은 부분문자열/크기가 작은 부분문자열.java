class Solution {
    public int solution(String t, String p) {
		int answer = 0;

		int length = p.length();
		long numP = Long.parseLong(p);
		for (int i = 0; i < t.length(); i++) {
			if (i + length <= t.length()) {
				String num = t.substring(i, i + length);
				if (numP >= Long.parseLong(num)) {
					answer++;
				}
			}

		}

        return answer;
    }
}