import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // n을 k진수 문자열로 변환
        String s = Integer.toString(n, k);
        
        // 0 하나 이상을 기준으로 잘라서 후보 숫자들만 뽑기
        String[] parts = s.split("0+");
        
        for (String part : parts) {
            if (part.length() == 0) continue;   // 공백 방지
            
            long num = Long.parseLong(part);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        // 3부터 sqrt(n)까지 홀수만 체크
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}