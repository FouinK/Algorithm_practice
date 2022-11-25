package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int value = Integer.parseInt(st.nextToken());
			int answer = Integer.parseInt(st.nextToken());

			visit = new boolean[10000];

			bfs(value, answer);
		}

		System.out.println(sb);
	}

	public static void bfs(int value, int answer) {
		Queue<Number> queue = new LinkedList<>();
		queue.add(new Number(value, ""));

		visit[value] = true;
		while (!queue.isEmpty()) {
			int num = queue.peek().num;
			String word = queue.peek().word;

			queue.poll();

			if (num == answer) {
				sb.append(word).append("\n");
				return;
			}

			int D = (num * 2) % 10000;

			int S = num - 1;

			if (S == -1) {
				S = 9999;
			}

			int L = (num % 1000) * 10 + num / 1000;

			int R = num / 10 + (num % 10) * 1000;

			if (!visit[D]) {
				visit[D] = true;
				queue.offer(new Number(D, word + "D"));
			}
			if (!visit[S]) {
				visit[S] = true;
				queue.offer(new Number(S, word + "S"));
			}
			if (!visit[L]) {
				visit[L] = true;
				queue.offer(new Number(L, word + "L"));
			}
			if (!visit[R]) {
				visit[R] = true;
				queue.offer(new Number(R, word + "R"));
			}
		}
	}

	public static class Number{
		int num;
		String word;

		public Number(int num, String word) {
			this.num = num;
			this.word = word;
		}
	}
}