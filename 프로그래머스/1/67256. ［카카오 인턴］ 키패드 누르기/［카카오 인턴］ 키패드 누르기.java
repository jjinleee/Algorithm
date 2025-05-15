import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb= new StringBuilder();
        
        
        //손위치
        int[] leftPo={3,0};
        int[] rightPo={3,2};
        
        
        for(int n : numbers){
            int row= n==0 ? 3 :(n-1)/3;
            int col= n==0 ? 1: (n-1)%3;
            //왼손
            if(col==0){
                sb.append("L");
                leftPo[0]=row;
                leftPo[1]=col;
            }
            //오른손
            else if(col==2){
                sb.append("R");
                rightPo[0]=row;
                rightPo[1]=col;
            }  
            //가운데일때
            else{
            //거리계산
                int leftdist=Math.abs(row-leftPo[0])+Math.abs(col-leftPo[1]);     
                int rightdist=Math.abs(row-rightPo[0])+Math.abs(col-rightPo[1]);                   //오른손이가까움
                if(leftdist> rightdist){
                    sb.append("R");
                    rightPo[0]=row;
                    rightPo[1]=col;
                } else if(leftdist< rightdist){ //왼손이 가까움
                    sb.append("L");
                    leftPo[0]=row;
                    leftPo[1]=col;
                } else {//거리가 같음
                    if(hand.equals("right")){
                        sb.append("R");
                        rightPo[0]=row;
                        rightPo[1]=col;
                    } else {
                            sb.append("L");
                            leftPo[0]=row;
                            leftPo[1]=col;                        
                    }
                }
            
            }
                
        }
        return sb.toString();
    }
}