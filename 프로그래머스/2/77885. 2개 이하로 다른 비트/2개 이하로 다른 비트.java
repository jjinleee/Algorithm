import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            long x = numbers[i];

            if (x % 2 == 0) {
                answer[i] = x + 1;
            } else {
                long bit = 1;

                while ((x & bit) != 0) {
                    bit <<= 1;
                }

                answer[i] = x + bit - (bit >> 1);
            }
        }

        return answer;
    }
}