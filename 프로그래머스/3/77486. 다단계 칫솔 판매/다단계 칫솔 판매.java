import java.util.*;
class Solution {
    Map<String,String> graph=new HashMap<>();
    Map<String,Integer> profit=new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n=enroll.length;
        
        for(int i=0;i<n;i++){
            graph.put(enroll[i],referral[i]);
            profit.put(enroll[i],0);
        }
        
        for(int i=0;i<seller.length;i++){
            String name=seller[i];
            int money=amount[i]*100;
            
            distribute(name,money);
        }
        
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=profit.get(enroll[i]);
        }
        
        return answer;
        
    }
    
    void distribute(String name, int money){
        if(money<1 || name.equals("-")) return;
        
        int give=money/10;
        int keep=money-give;
        
        profit.put(name, profit.get(name)+keep);
        
        distribute(graph.get(name), give);
    }
}