import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,0,target);
        
        return answer;
    }
    static void dfs(int sum, int[] numbers, int depth, int target){
        //다 도달했으면 정답여부 체크
        if(depth==numbers.length){
            if(sum==target) answer++;
            return;
        }
        
        //하나는 더하고 하나는 뺌
        dfs(sum-numbers[depth],numbers,depth+1, target);
        dfs(sum+numbers[depth],numbers,depth+1, target);
    }
}