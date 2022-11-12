package beakJoon.yoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] arr;
	static int N;
	static String answer = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String cut = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(cut.charAt(j)));
			}
		}

		partition(0, 0, N);

		System.out.println(answer);
	}

	public static void partition(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			answer += arr[row][col];
			return;
		}

		int newSize = size / 2;

		answer += "(";
		partition(row, col, newSize);
		partition(row, col+newSize, newSize);
		partition(row+newSize, col, newSize);
		partition(row+newSize, col+newSize, newSize);
		answer += ")";

	}

	public static boolean colorCheck(int row, int col, int size) {
		int nowNum = arr[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (nowNum != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
