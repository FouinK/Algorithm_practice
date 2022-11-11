package beakJoon.yoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		partition(R, C, (int) Math.pow(2, N));

		System.out.println(answer);
	}

	public static void partition(int r, int c, int size) {
		if (size == 1) {
			return;
		}
		int halfSize = size / 2;
		if (r < halfSize && c < halfSize) {
			partition(r,c,halfSize);
		} else if (r < halfSize && c >= halfSize) {
			answer += (size * size) / 4;
			partition(r, c - halfSize, halfSize);
		} else if (r >= halfSize && c < halfSize) {
			answer += ((size * size) / 4) * 2;
			partition(r - halfSize, c, halfSize);
		} else {
			answer += ((size * size) / 4) * 3;
			partition(r - halfSize, c - halfSize, halfSize);
		}
	}


}
