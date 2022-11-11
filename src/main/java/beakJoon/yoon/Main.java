package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] know;
	static int cnt;
	static int kevinCnt[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

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

		int min = Integer.MAX_VALUE;
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				know = new boolean[N + 1];
				kevinCnt = new int[N + 1];
				if (i != j) {
					sum += bfs(i, j);
				}
			}
			if (sum < min) {
				min = sum;
				answer = i;
			}
		}

		System.out.println(answer);

	}

	public static int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		know[start] = true;
		while (!queue.isEmpty()) {
			int start_point = queue.poll();
			Iterator<Integer> iterator = arr[start_point].iterator();
			while (iterator.hasNext()) {
				int next = iterator.next();
				if (!know[next]) {
					kevinCnt[next] = kevinCnt[start_point] + 1;
					if (next == end) {
						return kevinCnt[next];
					}
				}
				queue.offer(next);
			}
		}
		return 0;
	}


}
