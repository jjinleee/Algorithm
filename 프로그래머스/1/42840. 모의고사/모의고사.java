import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1={1,2,3,4,5};
        int[] p2={2,1,2,3,2,4,2,5};
        int[] p3={3,3,1,1,2,2,4,4,5,5};
        
        int[] s=new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==p1[i%5]) s[0]++;
            if(answers[i]==p2[i%8]) s[1]++;
            if(answers[i]==p3[i%10]) s[2]++;
        }
        
        int maxScore = Math.max(s[0], Math.max(s[1], s[2]));

        
        List<Integer> grade=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(maxScore==s[i]){
                grade.add(i+1);
            }
        }
        
        
        return grade.stream().mapToInt(i->i).toArray();
    }
}