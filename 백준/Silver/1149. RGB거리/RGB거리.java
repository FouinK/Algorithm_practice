
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N+1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + R;
			arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + G;
			arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + B;
		}

		System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));

	}
}