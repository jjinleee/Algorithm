import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer=0;
        int n=friends.length;
        
        //이름과 인덱스 매칭
        Map<String,Integer> name= new HashMap<>();
        for(int i=0;i<n;i++){
            name.put(friends[i],i);
        }
        
        //테이블표 생성, 초기화
        int[][] table=new int[n][n];
        for(int[] t:table){
            Arrays.fill(t, 0);
        }
        //테이블에 주고받은 선물 입력
        for(int i=0;i<gifts.length;i++){
            String[] names=gifts[i].split(" ");
            int give=name.get(names[0]);
            int take=name.get(names[1]);
            table[give][take]++;
        }
        

        //선물지수=준선물-받은선물=행더함-열더함
        int[] grade=new int[n];
        for(int i=0;i<n;i++){
            int gave=0;
            int took=0;
            for(int j=0;j<n;j++){
                gave+=table[i][j];
                took+=table[j][i];
            }
            grade[i]=gave-took;
        }
        
        
        //다음달 받을 선물 계산하기
        int[] next=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(i==j) continue;
                
                if(table[i][j]>table[j][i]) next[i]++;
                else if(table[i][j]==table[j][i]){
                    if(grade[i]>grade[j]) next[i]++;
                }
            }
        }
        
        //최댓값구하기
        int max=0;
        for(int p:next){
            max=Math.max(max,p);
        }
    
        

        return max;
    }
}