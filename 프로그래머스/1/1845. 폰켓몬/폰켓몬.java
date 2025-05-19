import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n= nums.length;
        
        //포켓몬 종류별로 카운트
        Map<Integer,Integer> pocketmons= new HashMap<>();
        for(int type: nums){
            pocketmons.put(type,pocketmons.getOrDefault(type,0)+1);
        }
        
        //종류가 n/2개 넘으면 그대로 리턴
        if(pocketmons.size()>=n/2) return n/2;
        else return pocketmons.size(); //안넘으면 종류 개수 반환
        
    }
}