package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] arr;
	static boolean visit[][];
	static int N;
	static int cnt = 0;
	static int separateCnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String get = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(get.charAt(j)));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					separateCnt = 0;
					cnt++;
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);

		for (int i : list) {
			sb.append(i).append("\n");
		}

		System.out.println(cnt);
		System.out.println(sb);
	}

	public static int bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{row, col});
		visit[row][col] = true;
		separateCnt++;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowRow = now[0];
			int nowCol = now[1];
			for (int i = 0; i < 4; i++) {
				int nextRow = nowRow + dr[i];
				int nextCol = nowCol + dc[i];

				if (nextRow >= N || nextCol >= N || nextRow < 0 || nextCol < 0) {
					continue;
				}

				if (visit[nextRow][nextCol] || arr[nextRow][nextCol] == 0) {
					continue;
				}
				visit[nextRow][nextCol] = true;
				queue.offer(new int[]{nextRow, nextCol});
				separateCnt++;
			}
		}
		return separateCnt;
	}
}