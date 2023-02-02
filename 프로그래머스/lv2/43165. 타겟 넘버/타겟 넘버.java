class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int result) {
                
        if (numbers.length == depth) {
            if (result == target) {
                answer++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(numbers, depth + 1, target, add);
        dfs(numbers, depth + 1, target, sub);

    }
}