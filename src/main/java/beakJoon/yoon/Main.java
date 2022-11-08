package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int tc = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
			visit[i] = false;
		}

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int start) {
		visit[start] = true;
		for (int i = 0; i < arr[start].size(); i++) {
			int next = arr[start].get(i);
			if (!visit[next]) {
				dfs(next);
			}
		}
	}
}