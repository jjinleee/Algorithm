import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long total= 0;
        for(int i=0;i<count;i++){
            total+=price*(i+1);
        }
        long answer= money-total;
        

        return answer>=0 ? 0 : Math.abs(answer);
    }
}