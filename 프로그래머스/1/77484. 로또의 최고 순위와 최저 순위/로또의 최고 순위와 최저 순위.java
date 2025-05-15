import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        //리스트에 넣기 (contains메소드 사용목적)
        List<Integer> win=new ArrayList<>();
        for(int n : win_nums){
            win.add(n);
        }
        
        int zero=0; //모르는숫자 개수
        int correct=0; //맞춘개수
        for(int l : lottos){
            if(l==0) zero++;
            if(win.contains(l)) correct++;
        }
        //모두 0일때
        if(zero==6) {
            answer[0]=1;
            answer[1]=6;
            return answer;    
        }
        //모두 맞췄을때
        if(correct==6){
            answer[0]=1;
            answer[1]=1;
            return answer;
        } 
        
        //최소=맞춘개수, 최대=모르는 숫자 개수 + 맞춘 개수
        int max=zero+correct;
        int min=correct;
        
        answer[0]=lottoRank(max);
        answer[1]=lottoRank(min);
        
        return answer;
    }
    static int lottoRank(int cnt){
        switch(cnt){
            case 6: 
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
        
    }
}