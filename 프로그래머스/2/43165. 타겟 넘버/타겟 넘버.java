import java.util.*;

class Solution {
    int answer=0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        return answer;
    }
    void dfs(int[] numbers, int target, int i, int cur){
        if(i==numbers.length){
            if(cur==target) answer++;
            return;
        }
        
        dfs(numbers, target, i+1, cur+numbers[i]);
        dfs(numbers, target, i+1, cur-numbers[i]);
    }
}