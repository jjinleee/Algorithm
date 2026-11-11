import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        int to=toDay(today);
        
        //약관종류,유효기간
        for(String t : terms){
            String[] term=t.split(" ");
            map.put(term[0],Integer.parseInt(term[1])*28);
        }
        
        for(int i=0;i<privacies.length;i++){
            String[] tmp=privacies[i].split(" ");
            int day=toDay(tmp[0]);
            String type=tmp[1];
            int max=day+map.get(type); //유효기간
            
            if(max<=to) list.add(i+1);
        }
        
        list.sort(Comparator.naturalOrder());
        
        return list.stream().mapToInt(i->i).toArray();
    }
    int toDay(String term){
        String[] tmp=term.split("\\.");
        
        return Integer.parseInt(tmp[0])*12*28+Integer.parseInt(tmp[1])*28+Integer.parseInt(tmp[2]);
    }
}