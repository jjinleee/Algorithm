import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q=new LinkedList<>();
        
        if(cacheSize==0) return 5*cities.length;
        
        for(String c : cities){
            String city=c.toLowerCase();
            
            if(q.isEmpty()){
                q.offer(city);
                answer+=5;
            } else if(q.contains(city)) {
                answer++;
                q.remove(city);
                q.offer(city);
            } else {
                if(q.size()<cacheSize){
                    q.offer(city);
                } else {
                    q.poll();
                    q.offer(city);
                }
                answer+=5;
            }
        }
        
        return answer;
    }
} 