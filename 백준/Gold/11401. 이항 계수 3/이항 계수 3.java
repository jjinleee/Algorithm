import java.io.*;
import java.util.*;

public class Main {
    static long p = 1000000007; // 모듈러 값
    static long[] factorial; // 팩토리얼 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 팩토리얼 계산
        factorial = new long[n + 1];
        computeFactorials(n);

        // 조합 계산
        long numer = factorial[n]; // n!
        long denom = (factorial[k] * factorial[n - k]) % p; // k! * (n-k)!

        // 결과 출력
        System.out.println((numer * pow(denom, p - 2)) % p);
    }

    // 팩토리얼 계산 (동적 계획법)
    public static void computeFactorials(int n) {
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % p;
        }
    }

    // 분할 정복을 이용한 거듭제곱 계산
    public static long pow(long base, long exp) {
        if (exp == 0) return 1; // x^0 = 1
        long half = pow(base, exp / 2);
        if (exp % 2 == 0) {
            return (half * half) % p;
        } else {
            return (((half * half) % p) * base) % p;
        }
    }
}