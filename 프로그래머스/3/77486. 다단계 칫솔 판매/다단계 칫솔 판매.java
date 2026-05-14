import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {        
        Map<String, Integer> money=new HashMap<>(); //판매자별 총금액
        for(String e : enroll) money.put(e, 0);
        
        Map<String, String> people=new HashMap<>(); //참여자, 참여시킨사람
        for(int i=0;i<referral.length;i++){
            people.put(enroll[i],referral[i]);
        }
        
        
        for(int i=0;i<seller.length;i++){
            int profit=amount[i]*100; //이익금
            String cur=seller[i];
            
            while(!cur.equals("-")){
                int give=profit/10;
                int keep=profit-give;
            
                money.put(cur, money.get(cur)+keep);
            
                if(give<1) break;
                //분배
                cur=people.get(cur); //그 윗단계사람
                profit=give;;
            }
        }
        
        
        int[] answer=new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            answer[i]=money.get(enroll[i]);
        }
        
        return answer;
    }
}