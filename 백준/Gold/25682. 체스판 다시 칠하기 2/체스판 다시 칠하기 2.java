import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행 (세로 크기)
        int m = Integer.parseInt(st.nextToken()); // 열 (가로 크기)
        int k = Integer.parseInt(st.nextToken()); // 체스판 크기

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] white = new int[n + 1][m + 1];
        int[][] black = new int[n + 1][m + 1];

        // 누적합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int isWhite = ((i + j) % 2 == 0 ? 'W' : 'B') != board[i][j] ? 1 : 0;
                int isBlack = ((i + j) % 2 == 0 ? 'B' : 'W') != board[i][j] ? 1 : 0;

                white[i + 1][j + 1] = white[i][j + 1] + white[i + 1][j] - white[i][j] + isWhite;
                black[i + 1][j + 1] = black[i][j + 1] + black[i + 1][j] - black[i][j] + isBlack;
            }
        }

        int paint = Integer.MAX_VALUE;

        // 슬라이딩 윈도우로 최소 값 계산
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int sumWhite = white[i][j] - white[i - k][j] - white[i][j - k] + white[i - k][j - k];
                int sumBlack = black[i][j] - black[i - k][j] - black[i][j - k] + black[i - k][j - k];

                paint = Math.min(paint, Math.min(sumWhite, sumBlack));
            }
        }

        System.out.println(paint);
    }
}