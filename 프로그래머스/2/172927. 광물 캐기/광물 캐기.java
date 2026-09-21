import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] need={{1,1,1},
                      {5,1,1},
                      {25,5,1}};
        int answer = 0;
        int total=0;
        for(int p : picks) total+=p;
        int max=Math.min(minerals.length, total*5); //최대로캘수있는 광물수
                
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<max;i+=5){
            int dia=0;
            int iron=0;
            int stone=0;
            int score=0;
            for(int j=i;j<i+5&&j<max;j++){        
                if(minerals[j].equals("diamond")) dia++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
                
                score=25*dia+5*iron+stone;
            }
            list.add(new int[]{dia,iron,stone,score});
        }
        list.sort((a,b)-> b[3]-a[3]);
        
        int tool=0;
        for(int[] l : list){
            if(total==0) return answer;
            
            while(picks[tool]==0 && tool<2) tool++; //다음 곡괭이
            answer+=(need[tool][0]*l[0]+need[tool][1]*l[1]+need[tool][2]*l[2]);
            picks[tool]--;
            total--;
            
        }
        
        return answer;
    }
}