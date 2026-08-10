import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }

        long factorial = 1;
        for(int i=1;i<n;i++){
            factorial *= i;
        }

        k--; // 0-based

        for(int i=0;i<n;i++){
            int idx = (int)(k / factorial);

            answer[i] = numbers.remove(idx);

            if(i == n-1) break;

            k %= factorial;
            factorial /= (n - 1 - i);
        }

        return answer;
    }
}