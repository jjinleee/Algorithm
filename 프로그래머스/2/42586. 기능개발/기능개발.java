import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] remain=new int[n];
        for(int i=0;i<n;i++){
            remain[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        List<Integer> list=new ArrayList<>();
        int start=remain[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            //덜걸리면 함꼐 배포
            if(start>=remain[i]){
                cnt++;
            } else{
                list.add(cnt);
                cnt=1;
                start=remain[i];
            }
        }
        
        list.add(cnt); //마지막 기능
        
        return list.stream().mapToInt(i->i).toArray();
    }
}