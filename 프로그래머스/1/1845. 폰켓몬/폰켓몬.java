import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n=nums.length;
        Map<Integer,Integer> pocket=new HashMap<>();
        
        for(int i=0;i<n;i++){
            pocket.put(nums[i],pocket.getOrDefault(nums[i],0)+1);
        }
        if(pocket.size()>=n/2) answer=n/2;
        else answer=pocket.size();
        
        return answer;
    }
}