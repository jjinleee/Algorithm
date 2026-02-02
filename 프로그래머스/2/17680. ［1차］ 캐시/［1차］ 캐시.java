import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> q= new ArrayDeque<>();
        for(String c : cities){
            String city=c.toLowerCase();
            //큐가 비었을때
            if(q.contains(city)){
                answer+=1; //캐시히트
                q.remove(city);
                q.offer(city);
            } else {
                q.offer(city);
                answer+=5;
                if(q.size()>cacheSize) q.poll();
            }
        }
        return answer;
    }
}