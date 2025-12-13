import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer=new LinkedList<>();
        int day=toDays(today);
        //유효기간 저장
        Map<String,Integer> t=new HashMap<>();
        for(String term : terms){
            String[] tmp=term.split(" ");
            t.put(tmp[0],Integer.parseInt(tmp[1]));
        }
        
        //만료기간
        for(int i=0;i<privacies.length;i++){
            String[] tmp=privacies[i].split(" ");
            String date=tmp[0];
            String type=tmp[1];
            
            int start=toDays(date);
            int end=start+t.get(type)*28;
            
            if(end<=day) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    int toDays(String date){
        String[] tmp=date.split("\\.");
        int y=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        int d=Integer.parseInt(tmp[2]);
        
        return y*12*28+m*28+d;
    }
}