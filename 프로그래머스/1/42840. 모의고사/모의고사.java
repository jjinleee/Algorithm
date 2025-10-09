import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list=new ArrayList<>();
        int[][] p={{1,2,3,4,5},
                   {2,1,2,3,2,4,2,5},
                   {3,3,1,1,2,2,4,4,5,5}};
        
        int[] cnt= new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==p[0][i%5]) cnt[0]++;
            if(answers[i]==p[1][i%8]) cnt[1]++;
            if(answers[i]==p[2][i%10]) cnt[2]++;
        }
        
        int max=cnt[0];
        for(int c : cnt){
            if(max<c) max=c;
        }
        
        for(int i=0;i<3; i++){
            if(max==cnt[i]){
                max=cnt[i];
                System.out.println(i);
                list.add(i+1);
            }
        }
        
        Collections.sort(list);
        
        
        return list.stream().mapToInt(i->i).toArray();
    }
}