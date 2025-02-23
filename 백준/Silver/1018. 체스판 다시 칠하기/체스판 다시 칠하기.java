import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] arr;
    public static int min = Integer.MAX_VALUE; // 최댓값으로 초기화

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        arr = new boolean[n][m];

        // 보드 입력 ('W' = true, 'B' = false)
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (line.charAt(j) == 'W');
            }
        }

        // 8x8 크기의 체스판을 자를 수 있는 모든 위치 검사
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                find(i, j);
            }
        }

        // 결과 출력
        System.out.println(min);
    }

    static void find(int x, int y) {
        int cnt1 = 0; // 좌상단이 흰색일 때
        int cnt2 = 0; // 좌상단이 검은색일 때

        for (int i = 0; i < 8; i++) { // 8x8 범위만 검사
            for (int j = 0; j < 8; j++) {
                boolean curr = arr[x + i][y + j]; // 현재 칸 색

                // 좌상단이 흰색(W)일 때
                if ((i + j) % 2 == 0) {
                    if (!curr) cnt1++; // 흰색이어야 하는데 검은색이면 카운트
                } else {
                    if (curr) cnt1++; // 검은색이어야 하는데 흰색이면 카운트
                }

                // 좌상단이 검은색(B)일 때
                if ((i + j) % 2 == 0) {
                    if (curr) cnt2++; // 검은색이어야 하는데 흰색이면 카운트
                } else {
                    if (!curr) cnt2++; // 흰색이어야 하는데 검은색이면 카운트
                }
            }
        }

        // 최소값 갱신
        min = Math.min(min, Math.min(cnt1, cnt2));
    }
}