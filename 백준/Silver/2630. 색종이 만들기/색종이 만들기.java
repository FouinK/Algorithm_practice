import java.util.Scanner;

public class Main {
	static int[][] board;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		board = new int[N][N];


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		partition(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void partition(int row, int col, int size) {

		if (colorCheck(row, col, size)) {
			if (board[row][col] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}

		int halfSize = size / 2;

		partition(row, col+ halfSize, halfSize);        //1사분면
		partition(row, col, halfSize);        //2사분면
		partition(row + halfSize, col, halfSize);        //3사분면
		partition(row + halfSize, col + halfSize, halfSize);        //4사분면

	}

	public static boolean colorCheck(int row, int col, int size) {
		int nowColor = board[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (board[i][j] != nowColor) {
					return false;
				}
			}
		}
		return true;
	}
}