import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> pocketmon=new HashMap<>();
        for(int n: nums){
            pocketmon.put(n,pocketmon.getOrDefault(n,0)+1);
        }
        
        int n=nums.length;
        if(pocketmon.size()>=n/2) return n/2;
        else return pocketmon.size();
    }
}