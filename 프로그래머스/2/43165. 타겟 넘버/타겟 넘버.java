import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    void dfs(int[] numbers, int idx, int cur, int target){
        if(idx==numbers.length){
            if(cur==target) answer++;
            return;
        }
        dfs(numbers, idx+1, cur+numbers[idx], target);
        dfs(numbers, idx+1, cur-numbers[idx], target);
    }
}