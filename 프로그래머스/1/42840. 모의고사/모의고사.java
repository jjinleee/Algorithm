import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] p={{1,2,3,4,5},
                   {2,1,2,3,2,4,2,5},
                   {3,3,1,1,2,2,4,4,5,5}};
        
        int[][] cnt= new int[3][2];
        for(int i=0;i<3;i++){
            int count=0;
            for(int j=0;j<answers.length;j++){
                if(answers[j]==p[i][j%p[i].length]) count++;
            }
            cnt[i][0]=i;
            cnt[i][1]=count;
        }
        
        //coun 내름차순
        Arrays.sort(cnt,(a,b)-> b[1]-a[1]);
        int max=cnt[0][1];
        
        List<Integer> answer=new ArrayList<>();
        for(int[] m : cnt){
            if(m[1]==max) answer.add(m[0]+1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
        
    }
}