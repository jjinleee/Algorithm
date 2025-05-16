import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //오늘 날짜
        int todayDay=toDays(today);
        //만료인덱스 담을 리스트
        List<Integer> answer=new ArrayList<>();
        
        //유효기간 저장
        Map<String,Integer> monthDuration=new HashMap<>();
        for(String t : terms){
            String[] temp=t.split(" ");
            monthDuration.put(temp[0],Integer.parseInt(temp[1]));
        }
        //개인정보 하나씩 검사
        for(int i=0;i<privacies.length;i++){
            String[] tmp=privacies[i].split(" ");
            String date=tmp[0];
            String type=tmp[1];
            
            int start=toDays(date);
            int end=start+monthDuration.get(type)*28;
            
            if(end<=todayDay) answer.add(i+1); //만료시 저장
        }
        
       
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    //일수로 변환
    static int toDays(String date){
        String[] parts=date.split("\\.");
        int y=Integer.parseInt(parts[0]);
        int m=Integer.parseInt(parts[1]);
        int d=Integer.parseInt(parts[2]);
        
        return y*12*28+m*28+d;
    }
}