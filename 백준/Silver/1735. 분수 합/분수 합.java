import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        // 최소공배수 구하기
        int lcm = lcm(b, b2);

        // 분자 조정
        a = a * (lcm / b);
        a2 = a2 * (lcm / b2);

        // 분자 합산
        int numerator = a + a2;
        int denominator = lcm;

        // 최대공약수를 구해 기약분수 만들기
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        System.out.println(numerator + " " + denominator);
    }

    // 최대공약수(GCD) 계산 함수
    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // 최소공배수(LCM) 계산 함수
    public static int lcm(int x, int y) {
        return x * (y / gcd(x, y));
    }
}