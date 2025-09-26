import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> pocketmons= new HashMap<>();
        for(int n : nums){
            pocketmons.put(n,pocketmons.getOrDefault(n,0)+1);
        }
        
        
        int max = pocketmons.keySet().size();
        if(nums.length/2<=max) return nums.length/2;
        else return max;
    }
}