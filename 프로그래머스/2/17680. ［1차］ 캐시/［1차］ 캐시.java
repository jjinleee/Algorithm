import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) return 5*cities.length; 
        
        Queue<String> q= new ArrayDeque<>();
        for(String city : cities){
            city=city.toLowerCase();
            if(!q.isEmpty() && q.contains(city)){
                answer++;
                q.remove(city);
            } else{
                if(q.size()==cacheSize){
                    q.poll();
                }
                answer+=5;
            }
            q.offer(city);
        }
        
        return answer;
    }
}