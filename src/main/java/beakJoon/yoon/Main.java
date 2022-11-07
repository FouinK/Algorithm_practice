package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static ArrayList<Integer>[] arr;
	static int computer, node;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		computer = Integer.parseInt(st.nextToken());


		arr = new ArrayList[computer + 1];
		visit = new boolean[computer + 1];

		for (int i = 1; i < computer+1; i++) {
			arr[i] = new ArrayList<>();
			visit[i] = false;
		}

		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());

		for (int i = 0; i < node; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		dfs(1);
		System.out.println(answer);
	}

	public static void dfs(int start) {
		visit[start] = true;
		for (int i = 0; i < arr[start].size(); i++) {
			int next = arr[start].get(i);
			if (!visit[next]) {
				answer++;
				dfs(next);
			}
		}

	}
}