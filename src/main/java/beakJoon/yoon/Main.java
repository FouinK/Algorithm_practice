package beakJoon.yoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static int[] location1 = {-1, 1, 0, 0};
	static int[] location2 = {0, 0, -1, 1};
	static boolean[][] visit;
	static int answer = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		visit = new boolean[N][M];
		visit[0][0] = true;

		for (int i = 0; i < N; i++) {
			String getInput = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(getInput.charAt(j)));
			}
		}

		bfs(0, 0);
		System.out.println(arr[N-1][M-1]);
	}

	public static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowRow = now[0];
			int nowCol = now[1];
			for (int i = 0; i < 4; i++) {
				int nextRow = nowRow - location1[i];
				int nextCol = nowCol - location2[i];

				if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
					continue;
				}

				if (arr[nextRow][nextCol] == 0 || visit[nextRow][nextCol]) {
					continue;
				}
				queue.offer(new int[]{nextRow, nextCol});
				visit[nextRow][nextCol] = true;
				arr[nextRow][nextCol] = arr[nowRow][nowCol]+1;
			}
		}
	}
}