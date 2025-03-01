import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> sum=new ArrayList<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                int n=numbers[i]+numbers[j];
                if(!sum.contains(n)) sum.add(n);
            }
        }
        Collections.sort(sum);
        
        return sum.stream().mapToInt(i->i).toArray();
    }
}