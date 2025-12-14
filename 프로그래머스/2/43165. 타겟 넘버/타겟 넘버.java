import java.util.*;

class Solution {
    int cnt=0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers,0,0,target);
        
        return cnt;
        
    }
    void dfs(int[] numbers, int idx, int current, int target){
        if(idx==numbers.length){
            if(current==target) cnt++;
            return;
        }
        
        dfs(numbers, idx+1, current+numbers[idx],target);
        dfs(numbers, idx+1, current-numbers[idx],target);
    }
}