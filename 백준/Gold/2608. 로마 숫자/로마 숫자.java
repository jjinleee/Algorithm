import java.io.*;
import java.util.*;

public class Main {

    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int val = map.get(s.charAt(i));
            if (i + 1 < len) {
                int next = map.get(s.charAt(i + 1));
                if (val < next) {
                    sum -= val;      // 작은 값이 앞에 오면 빼기
                    continue;
                }
            }
            sum += val;
        }
        return sum;
    }

    private static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine().trim();
        String b = br.readLine().trim();

        int v1 = romanToInt(a);
        int v2 = romanToInt(b);
        int sum = v1 + v2;

        System.out.println(sum);
        System.out.println(intToRoman(sum));
    }
}