import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int cur=0;
        
        while(storey!=0){
            cur=storey%10;
            if(cur<5) answer+=cur;
            else if(cur>5) {
                answer+=(10-cur);
                storey+=10; //한자릿수 올림
            } else { //5일때 다음자릿수
                int next=storey/10%10;
                
                if(next>=5) {
                    answer+=(10-cur);
                    storey+=10;
                    
                } else answer+=5;
                
            }
            
            storey/=10;
        }
        
        return answer;
    }
}