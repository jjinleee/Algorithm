import java.util.*;

class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers, target, 0);
        
        return answer;
    }
    static void dfs(int current, int[] numbers, int target, int depth){
        if(depth==numbers.length){
            if(current==target) answer++;
            return;
        }
        
        dfs(current+numbers[depth], numbers, target, depth+1);
        dfs(current-numbers[depth], numbers, target, depth+1);
        
    }
}