import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int n= weights.length;
        Arrays.sort(weights);
        
        Map<Integer,Integer> map=new HashMap<>();
        for(int w : weights){
            map.put(w, map.getOrDefault(w,0)+1);
        }
        
        for(int p : map.keySet()){
            int cnt=map.get(p);
            //값이 1:1
            if(cnt>=2) answer+=(long)cnt*(cnt-1)/2;
            //값이 1:2
            if(map.containsKey(2*p)) answer+=(long)cnt*map.get(2*p);
            //값이 2:3
            if(3*p%2==0 && map.containsKey(3*p/2)) answer+=(long)cnt* map.get(3*p/2);
            //값이 3:4
            if(4*p%3==0 && map.containsKey(4*p/3)) answer+=(long)cnt*map.get(4*p/3);
        }
        
        return answer;
    }
}