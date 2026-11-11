import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n=discount.length;
        //원하는거
        Map<String,Integer> jeong=new HashMap<>();
        for(int i=0;i<want.length;i++) jeong.put(want[i],number[i]);
        
        //초기10일
        Map<String,Integer> cur=new HashMap<>();
        for(int i=0;i<10;i++){
            String dist=discount[i];
            cur.put(dist, cur.getOrDefault(dist,0)+1);
        }
        
        if(cur.equals(jeong)) answer++;
        
        for(int i=0;i<n-10;i++){
            String front=discount[i];
            cur.put(front, cur.get(front)-1);
            String back=discount[i+10];
            cur.put(back, cur.getOrDefault(back,0)+1);
            
            boolean sale=true;
            for(String w : jeong.keySet()){
                if(cur.containsKey(w) && jeong.get(w)<=cur.get(w)) continue;
                else{
                    sale=false;
                    break;
                }
            }
            
            if(sale) answer++;
        }
        return answer;
    }
}