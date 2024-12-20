import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] prefix = new long[n+1]; // 누적 합
        long[] remainder = new long[m]; // 나머지 개수 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + Integer.parseInt(st.nextToken());
            int mod = (int) ((prefix[i] % m + m) % m);  // 음수 나머지 방지
            remainder[mod]++;
        }

        long result = remainder[0]; // 나머지가 0인 경우 직접 더함
        for (int i = 0; i < m; i++) {
            if (remainder[i] > 1) {
                result += (remainder[i] * (remainder[i] - 1)) / 2;  // 조합 계산
            }
        }

        System.out.println(result);
    }
}