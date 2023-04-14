class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    
                    boolean check = false;
                    
                    for (int k = 0; k < 8; k++) {
                        if (i + dx[k] >= 0 && i + dx[k] < board.length && j + dy[k] >= 0 && j + dy[k] < board.length) {
                            if (board[i + dx[k]][j + dy[k]] == 1) {
                                check = true;
                                break;
                            }
                        }
                    }

                    if (!check) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}