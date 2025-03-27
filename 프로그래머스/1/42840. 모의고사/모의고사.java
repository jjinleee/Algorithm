import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] p1={1,2,3,4,5};
        int[] p2={2,1,2,3,2,4,2,5};
        int[] p3={3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt=new int[3];
        
        int n= answers.length;
        for(int i=0;i<n;i++){
            if(answers[i]==p1[i%5]) cnt[0]++;
            if(answers[i]==p2[i%8]) cnt[1]++;
            if(answers[i]==p3[i%10]) cnt[2]++;
        }
        
        int max=Math.max(cnt[0],Math.max(cnt[1],cnt[2]));
        
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<3;i++){
            if(cnt[i]==max) result.add(i+1);
        }
        
        Collections.sort(result);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}