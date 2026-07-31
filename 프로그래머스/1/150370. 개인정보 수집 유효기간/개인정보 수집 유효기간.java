import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayReal=trans(today);
        
        //약관 유효기간 저장
        Map<Character, Integer> limit=new HashMap<>();
        for(String t : terms){
            String[] tmp=t.split(" ");
            limit.put(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
        }
        
        //번호별 파기일 저장
        Map<Integer, Integer> num=new HashMap<>();
        for(int i=1;i<=privacies.length;i++){
            String[] tmp=privacies[i-1].split(" ");
            int day=trans(tmp[0]);
            char type=tmp[1].charAt(0);
            num.put(i, day+limit.get(type)*28);
        }
        
        List<Integer> list=new ArrayList<>();
        for(int i : num.keySet()){
            if(num.get(i)<=todayReal) list.add(i);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
    int trans(String day){
        String[] tmp=day.split("\\.");
        int y=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        int d=Integer.parseInt(tmp[2]);
        
        return 12*28*y+28*m+d;
    }
}