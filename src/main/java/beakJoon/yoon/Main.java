package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] cnt = new int[101];
	static int[] ladderAndSnake = new int[101];
	static boolean[] visit = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ladderSize = Integer.parseInt(st.nextToken());
		int snakeSize = Integer.parseInt(st.nextToken());


		for (int i = 0; i < ladderSize+snakeSize; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ladderAndSnake[a] = b;
		}
		bfs();

	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		cnt[1] = 0;
		visit[1] = true;

		while (!queue.isEmpty()) {
			int nowLocation = queue.poll();
			if (nowLocation == 100) {
				System.out.println(cnt[100]);
				return;
			}

			for (int i = 1; i < 7; i++) {
				int nextLocation = nowLocation + i;
				if (nextLocation < 101 && !visit[nextLocation] ) {
					visit[nextLocation] = true;

					if (ladderAndSnake[nextLocation] > 0) {
						if (!visit[ladderAndSnake[nextLocation]]) {
							cnt[ladderAndSnake[nextLocation]] = cnt[nowLocation] + 1;
							visit[ladderAndSnake[nextLocation]] = true;
							queue.offer(ladderAndSnake[nextLocation]);
						}
					} else {
						cnt[nextLocation] = cnt[nowLocation] + 1;
						queue.offer(nextLocation);
					}
				}
			}
		}
	}
}