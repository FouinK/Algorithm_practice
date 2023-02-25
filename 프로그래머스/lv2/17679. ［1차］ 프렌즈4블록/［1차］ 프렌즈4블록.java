class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        boolean[][] check = new boolean[m][n];
        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {

            boolean finish = true;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '1' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j] = true;
                        check[i+1][j+1] = true;
                        finish = false;
                    }
                }
            }

            if (finish) {
                break;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '1';
                        check[i][j] = false;
                        answer++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0 ; j--) {
                    if (map[j][i] == '1') {
                        int idx = j;
                        while (idx-- > 0) {
                            if (map[idx][i] != '1') {
                                map[j][i] = map[idx][i];
                                map[idx][i] = '1';
                                break;
                            }
                        }
                    }
                }
            }

        }

        return answer;
    }
}