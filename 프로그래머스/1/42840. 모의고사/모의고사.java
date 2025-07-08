import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] people={
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] result=new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i]==people[0][i%5]) result[0]++;
            if(answers[i]==people[1][i%8]) result[1]++;
            if(answers[i]==people[2][i%10]) result[2]++;
        }
        
        int[] tmp=result.clone();
        Arrays.sort(tmp);
        int max= tmp[2];
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<3;i++){
            if(max==result[i]) list.add(i+1);
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}