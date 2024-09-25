import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 수
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int M = Integer.parseInt(st.nextToken());  // 선택할 원소의 개수
            int N = Integer.parseInt(st.nextToken());  // 전체 원소의 개수

            sb.append(combination(N, M)).append("\n");  // 조합 결과를 계산 후 저장
        }

        System.out.println(sb.toString());  // 최종 결과 출력
    }

    // 조합 계산 함수: NCM = N! / (M! * (N-M)!)
    public static long combination(int N, int M) {
        long result = 1;
        // NCM 계산
        for (int i = 0; i < M; i++) {
            result *= (N - i);        // N * (N-1) * ... * (N-M+1)
            result /= (i + 1);        // 1 * 2 * ... * M
        }
        return result;
    }
}