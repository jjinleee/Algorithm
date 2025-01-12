import java.io.*;

public class Main {
    public static int[][] video;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        quad(0, 0, n);
        System.out.println(sb);
    }

    public static void quad(int row, int col, int size) {
        if (isUniform(row, col, size)) {
            sb.append(video[row][col]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quad(row, col, newSize);
        quad(row, col + newSize, newSize);
        quad(row + newSize, col, newSize);
        quad(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    public static boolean isUniform(int row, int col, int size) {
        int color = video[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}