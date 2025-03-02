import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());  // 입력값을 long으로 받음
            sb.append(findNextPrime(n)).append("\n");
        }

        System.out.print(sb);
    }

    public static long findNextPrime(long n) {
        if (n <= 2) return 2;
        if (n % 2 == 0) n++; // 짝수면 다음 홀수부터 검사 (2 제외)

        while (!isPrime(n)) {
            n += 2; // 홀수만 검사
            if (n < 0) return Long.MAX_VALUE; // 오버플로우 방지
        }

        return n;
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}