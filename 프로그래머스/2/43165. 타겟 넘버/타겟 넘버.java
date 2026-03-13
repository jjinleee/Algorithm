import java.util.*;

class Solution {
    int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers, target);
        
        return answer;
    }
    void dfs(int cur, int idx, int[] numbers, int target){
        if(idx==numbers.length){
            if(cur==target) answer++;
            return;
        }
        
        dfs(cur+numbers[idx], idx+1, numbers, target);
        dfs(cur-numbers[idx], idx+1, numbers, target);
    }
}