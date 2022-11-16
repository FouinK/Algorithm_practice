package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int col;
	static int row;
	static int height;
	static int[][][] box;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static Queue<int[]> queue = new LinkedList<>();
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		box = new int[height][row][col];
		boolean noZero = true;
		for (int k = 0; k < height; k++) {
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if (box[k][i][j] == 1) {
						queue.offer(new int[]{k, i, j});
					}

					if (box[k][i][j] == 0) {
						noZero = false;
					}
				}
			}
		}

		if (noZero) {
			System.out.println(0);
			return ;
		}

		bfs();
		for (int[][] ints : box) {
			for (int[] anInt : ints) {
				for (int i : anInt) {
					if (i == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer-1);


	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int z = poll[0];
			int x = poll[1];
			int y = poll[2];

			for (int i = 0; i < 6; i++) {
				int spread_z = z + dz[i];
				int spread_x = x + dx[i];
				int spread_y = y + dy[i];

				if (spread_z>=0 && spread_z < height && spread_x >= 0 && spread_x < row && spread_y >= 0 && spread_y < col) {
					if (box[spread_z][spread_x][spread_y] == 0) {
						box[spread_z][spread_x][spread_y] = box[z][x][y] + 1;
						queue.offer(new int[]{spread_z, spread_x, spread_y});
					}
				}
				answer = Math.max(answer, box[z][x][y]);
			}
		}
	}
}