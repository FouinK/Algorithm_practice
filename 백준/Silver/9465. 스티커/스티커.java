
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());

            arr = new int[2][size+1];
            int[][] dp = new int[2][size+1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 1; k <= size; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= size; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }
            sb.append(Math.max(dp[0][size], dp[1][size])).append("\n");

        }

        System.out.println(sb);
    }
}