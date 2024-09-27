import java.util.*;
import java.io.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[][] counsel = new int[n+1][2];  // 상담 기간과 금액을 저장하는 배열
            int[] dp = new int[n+2];  // dp[i]는 i번째 날부터 최대 수익을 저장

            // 상담 정보 입력
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                counsel[i][0] = Integer.parseInt(st.nextToken());  // 상담 기간
                counsel[i][1] = Integer.parseInt(st.nextToken());  // 상담 금액
            }

            // 역순으로 DP 계산 (n일부터 1일까지)
            for (int i = n; i >= 1; i--) {
                int time = counsel[i][0];  // 상담 기간
                int profit = counsel[i][1];  // 상담 금액

                // 현재 상담을 할 수 있는지 확인
                if (i + time <= n + 1) {
                    // 상담을 하는 경우와 하지 않는 경우 중 최댓값 선택
                    dp[i] = Math.max(dp[i + 1], profit + dp[i + time]);
                } else {
                    // 상담을 할 수 없으면, 이전과 동일한 값으로 유지
                    dp[i] = dp[i + 1];
                }
            }

            // 첫째 날부터 얻을 수 있는 최대 수익 출력
            System.out.println(dp[1]);
        }
}