
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int cur[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					cur = new int[]{i, j};
					map[i][j] = 0;
				}
			}
		}

		int size = 2;
		int eat = 0;
		int move = 0;

		while (true) {
			PriorityQueue<int[]> queue =
					new PriorityQueue<>((o1, o2) ->
							o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

			boolean[][] visit = new boolean[N][N];
			boolean check = false;

			queue.offer(new int[]{cur[0], cur[1], 0});
			visit[cur[0]][cur[1]] = true;

			while (!queue.isEmpty()) {
				cur = queue.poll();

				if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
					map[cur[0]][cur[1]] = 0;
					eat++;
					move += cur[2];
					check = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int row = cur[0] + dr[i];
					int col = cur[1] + dc[i];

					if (row < 0 || col < 0 || row >= N || col >= N || visit[row][col] || map[row][col] > size) {
						continue;
					}
					queue.offer(new int[]{row, col, cur[2]+1});
					visit[row][col] = true;
				}
			}
			if (!check) {
				break;
			}

			if (size == eat) {
				size++;
				eat = 0;
			}
		}

		System.out.println(move);
	}
}