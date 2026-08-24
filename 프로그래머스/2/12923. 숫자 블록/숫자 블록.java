import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer= new int[(int)(end-begin)+1];
        
        int idx=0;
        for(long i=begin;i<=end;i++){
            if(i==1){
                answer[idx++]=0;
                continue;
            }
            
            int result=1;
            
            for(long d=2;d*d<=i;d++){
                if(i%d==0){
                    long large=i/d;
                    if(large<=10_000_000){
                        result=(int)large;
                        break;
                    }
                    
                    if(d<=10_000_000){
                        result=(int)d;
                    }
                }
            }
            answer[idx++]=result;

        }
        return answer;
    }
}