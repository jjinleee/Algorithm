import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n=nums.length;
        Map<Integer,Integer> list= new HashMap<>();
        
        for(int i=0;i<n;i++){
            list.put(nums[i],list.getOrDefault(nums[i],0)+1);
        }
        if(list.size()< n/2) answer=list.size();
        else answer=n/2;
        
        return answer;
    }
}