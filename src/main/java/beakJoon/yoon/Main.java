package beakJoon.yoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
			if (Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			} else {
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int value = sc.nextInt();
			if (value != 0) {
				queue.offer(value);
			} else {
				if (queue.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}