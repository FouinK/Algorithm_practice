package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visit;
	static int[] answer;
	static int N;
	static int M;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visit = new boolean[N];
		answer = new int[M];
		ans = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}


		Arrays.sort(arr);

		dfs(0);

		StringBuilder sb = new StringBuilder();

		for (String an : ans) {
			sb.append(an).append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int value : answer) {
				sb.append(value).append(" ");
			}
			ans.add(sb.toString());
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				answer[depth] = arr[i];
				visit[i] = true;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}