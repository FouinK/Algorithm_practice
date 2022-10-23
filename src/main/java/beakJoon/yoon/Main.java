package beakJoon.yoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int arr[][];
	static boolean check[];

	public static void main(String[] args)   {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		arr = new int[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		getDfs(V);
		System.out.println();
		getBfs(V);
	}

	private static void getDfs(int start) {
		check[start] = true;
		System.out.print(start + " ");

		for (int i = 1; i < arr.length; i++){
			if (check[i] == false && arr[start][i] == 1) {
				getDfs(i);
			}
		}
	}

	private static void getBfs(int start) {
		getInitCheck();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int poll = queue.poll();
			System.out.print(poll + " ");
			check[poll] = true;
			for (int i = 1; i < arr.length; i++) {
				if (poll != i && arr[poll][i] == 1 && check[i] == false) {
					queue.offer(i);
					check[i] =true;
				}
			}
		}

	}

	private static void getInitCheck() {
		Arrays.fill(check, false);
	}
}
