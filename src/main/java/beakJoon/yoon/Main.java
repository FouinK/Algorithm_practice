package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			arr[i].sort((a, b) -> a - b);
		}

		visit = new boolean[N + 1];
		dfs(start);
		sb.append("\n");
		visit = new boolean[N + 1];
		bfs(start);

		System.out.println(sb);

	}

	public static void dfs(int start) {
		sb.append(start).append(" ");
		visit[start] = true;
		for (int i = 0; i < arr[start].size(); i++) {
			int next = arr[start].get(i);
			if (!visit[next]) {
				dfs(next);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			for (int i = 0; i < arr[now].size(); i++) {
				int next = arr[now].get(i);
				if (!visit[next]) {
					visit[next] = true;
					queue.offer(next);
				}
			}
		}
	}
}