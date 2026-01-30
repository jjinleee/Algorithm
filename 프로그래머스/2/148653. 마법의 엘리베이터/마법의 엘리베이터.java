import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;     // 현재 자리
            int next  = (storey / 10) % 10; // 다음 자리 (없으면 0으로 취급돼도 무방)
            
            if (digit < 5) {
                // 그냥 내려가는 게 이득
                answer += digit;
                storey /= 10;
            } else if (digit > 5) {
                // 올리는 게 이득
                answer += (10 - digit);
                storey = storey / 10 + 1;   // 올리고 carry
            } else { // digit == 5
                // 다음 자리를 보고 결정
                if (next >= 5) {
                    // 올리는 쪽으로 몰아주는 게 유리
                    answer += 5;
                    storey = storey / 10 + 1;
                } else {
                    // 그냥 내리는 쪽
                    answer += 5;
                    storey /= 10;
                }
            }
        }
        
        return answer;
    }
}