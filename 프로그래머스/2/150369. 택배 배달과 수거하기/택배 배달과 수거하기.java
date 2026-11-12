import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d=n-1;
        int p=n-1;
        
        while(d>=0 || p>=0){
            int davail=cap;
            //배달,수거가 남아있는 가장 먼 위치 확인
            while(d>=0 && deliveries[d]==0) d--;
            while(p>=0 && pickups[p]==0) p--;
            
            answer+=(Math.max(d,p)+1)*2; //이동거리누적
            
            //if()
            //배달 cap개 처리
            while(d>=0 && davail>0){
                if(deliveries[d]>=davail){
                    deliveries[d]-=davail;
                    davail=0;
                } else { 
                    davail-=deliveries[d];
                    deliveries[d]=0;
                    d--;
                }
            }
            int pavail=cap;
            //픽업 cap개 처리
            while(p>=0 && pavail>0){
                if(pickups[p]>=pavail){
                    pickups[p]-=pavail;
                    pavail=0;
                } else { 
                    pavail-=pickups[p];
                    pickups[p]=0;
                    p--;
                }                
            }
        }
    
        
        return answer;
    }
}