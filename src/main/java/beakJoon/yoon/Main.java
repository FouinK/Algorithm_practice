package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int X, Y, K;
	static boolean[][] visit;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tc = Integer.parseInt(st.nextToken());

		for (int i = 0; i < tc; i++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			arr = new int[Y][X];
			visit = new boolean[Y][X];
			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[y][x] = 1;
			}

			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					if (arr[j][k] == 1 && !visit[j][k]) {
						dfs(j, k);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}

	}

	static void dfs(int y, int x) {
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ry = y + dy[i];
			int rx = x + dx[i];
			if (ry >= 0 && rx >= 0 && ry < Y && rx < X) {
				if (arr[ry][rx] == 1 && !visit[ry][rx]) {
					dfs(ry, rx);
				}
			}
		}
	}


}