import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> sum=new ArrayList<Integer>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                int num=numbers[i]+numbers[j];
                if(!sum.contains(num)){
                   sum.add(num);
                }
            }
        }
        Collections.sort(sum);
        int[] answer= new int[sum.size()];
        for(int i=0;i<sum.size();i++){
            answer[i]=sum.get(i);
        }
        return answer;
    }
}