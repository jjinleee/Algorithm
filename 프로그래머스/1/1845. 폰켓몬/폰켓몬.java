import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        int n=nums.length;
        if(map.size()>=n/2) answer=n/2;
        else answer=map.size();
        
        return answer;
    }
}