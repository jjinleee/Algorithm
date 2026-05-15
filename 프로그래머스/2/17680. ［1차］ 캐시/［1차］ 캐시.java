import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {

            return cities.length * 5;

        }
        
        Queue<String> q= new LinkedList<>();
        
        for(String c : cities){
            c=c.toLowerCase();
            if(!q.isEmpty() && q.contains(c)){ //캐시히트
                q.remove(c);
                q.offer(c); 
                answer+=1;
            } else {//캐시미스
                answer+=5;
                if(q.size()>=cacheSize){ //LRU
                   q.poll();
                }
                q.offer(c); 
                
            }
        }
        return answer;
    }
}