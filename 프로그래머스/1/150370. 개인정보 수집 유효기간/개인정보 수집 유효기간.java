import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list=new ArrayList<>();
        Map<Character, Integer> term=new HashMap<>(); //약관종류별 유효개월
        for(String t : terms){
            String[] tmp=t.split(" ");
            term.put(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
        }
        
        int now=todays(today); //오늘날짜
    
        for(int i=0;i<privacies.length;i++){
            int date=todays(privacies[i].split(" ")[0]); //가입일
            char c= privacies[i].split(" ")[1].charAt(0); //약관종류
            int m= term.get(c); //유효개월
            
            
            if(now-date>= 28*m) list.add(i+1);
        }
        
        
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    int todays(String s){
        String[] tmp=s.split("\\.");
        int y=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        int d=Integer.parseInt(tmp[2]);
        
        return 28*12*y+28*m+d;
    }
}