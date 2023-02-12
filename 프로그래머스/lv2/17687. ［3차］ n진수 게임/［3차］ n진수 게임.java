class Solution {
    public String solution(int n, int t, int m, int p) {
                
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= m*t; i++) {
            String s = Integer.toString(i, n);
            sb.append(s);
        }

        String result = sb.toString();
        sb = new StringBuilder();
        int cnt = 0;
        
        for (int i = p-1; i<result.length(); i += m) {
            
            sb.append(result.charAt(i));
            cnt++;
            
            if(cnt == t) {
                break;
            }

        }

        return sb.toString().toUpperCase();
    }
}