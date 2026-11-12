import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer,Double> map=new HashMap<>();//실패율,단계
        for(int i=1;i<=N; i++) map.put(i,0.0);
        
    
        for(int i=1;i<=N;i++){
            int a=0;
            int b=0;
            for(int s : stages){
                if(s>=i) a++;
                if(s==i) b++;
            }
            if(b!=0) map.put(i,(double)b/a);
        }
        
        List<Map.Entry<Integer,Double>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b)-> Double.compare(b.getValue(),a.getValue()));
        int[] answer=new int[N];
        int idx=0;
        for(Map.Entry<Integer,Double> l : list){
            answer[idx++]=l.getKey();
        }
        
        return answer;
    }
}