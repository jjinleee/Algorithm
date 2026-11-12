import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] day=new int[n];
        
        for(int i=0;i<n;i++){
            day[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        List<Integer> list=new ArrayList<>();
        int first=day[0];
        int sum=1;
        int idx=1;
        
        while(idx<n){
            if(first>=day[idx]){
                sum++;
            } else {
                list.add(sum);
                sum=1;
                first=day[idx];
            }
            idx++;
        }
        
        list.add(sum); //마지막
        
        return list.stream().mapToInt(i->i).toArray();
    }
}