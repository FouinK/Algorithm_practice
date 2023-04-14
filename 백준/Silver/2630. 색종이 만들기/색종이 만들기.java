

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int halfSize = size / 2;


        partition(row, col + halfSize, halfSize);                       //1사
        partition(row, col, halfSize);                                       //2사
        partition(row + halfSize, col, halfSize);                       //3사
        partition(row + halfSize, col + halfSize, halfSize);       //4사
    }

    public static boolean colorCheck(int row, int col, int size) {
        int newColor = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != newColor) {
                    return false;
                }
            }
        }

        return true;
    }
}