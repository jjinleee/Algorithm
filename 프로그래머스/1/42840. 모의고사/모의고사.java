import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer=new ArrayList<>();
        int[] score=new int[3];
        int[][] p={{1,2,3,4,5},
                   {2,1,2,3,2,4,2,5},
                   {3,3,1,1,2,2,4,4,5,5}};
        
        
        //각 맞힌 개수 셈
        for(int i=0;i<answers.length;i++){
            if(answers[i]==p[0][i%p[0].length]) score[0]++;
            if(answers[i]==p[1][i%p[1].length]) score[1]++;
            if(answers[i]==p[2][i%p[2].length]) score[2]++;
        }
        
        
        //최대점수
        int max=Math.max(score[0],Math.max(score[1],score[2]));
        
        //가장높은 점수를 받은 사람의 인덱스 넣기(자동 오름차순))
        for(int i=0;i<3;i++){
            if(score[i]==max){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}