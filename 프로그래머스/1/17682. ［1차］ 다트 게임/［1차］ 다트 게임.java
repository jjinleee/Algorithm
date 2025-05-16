import java.util.*;

class Solution {
    public int solution(String dartResult) {
        
        List<Integer> scores=new ArrayList<>();
        //반복문 어떻게 작성?
        int i=0;
        while(i<dartResult.length()){
            int score=0;
            
            //1.숫자
            //10은따로 처리해야함
            if(i+1<dartResult.length() && dartResult.charAt(i)=='1' && dartResult.charAt(i+1)=='0'){
                score=10;
                i+=2;
            } else {
                score=dartResult.charAt(i)-'0';
                i++;
            }
            
            //2.S,D,T
            if(dartResult.charAt(i)=='D') score=(int)Math.pow(score,2);
            else if(dartResult.charAt(i)=='T') score=(int)Math.pow(score,3);
            i++;
            
            //3. #, *
            if(i<dartResult.length()){
                char o=dartResult.charAt(i);
                if(o=='*'){
                    score*=2;
                    //이전것도 모두 2배
                    if(!scores.isEmpty()){
                        int last=scores.size()-1;
                        scores.set(last, scores.get(last)*2);
                    }
                    i++;
                } else if(o=='#'){
                    score*=-1;
                    i++;
                }
            }
            scores.add(score);
            
        }
        return scores.stream().mapToInt(Integer::intValue).sum();
    }
}