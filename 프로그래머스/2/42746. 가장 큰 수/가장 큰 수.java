import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        //String으로 모두 변환
        String[] nums=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            nums[i]=String.valueOf(numbers[i]);
        }
        
        // 정렬 
        Arrays.sort(nums, (a,b)-> (b+a).compareTo(a+b));
        
        
        //맨앞이 0이면 0반환하도록 함
        if(nums[0].equals("0")) return "0";
        StringBuilder sb= new StringBuilder();
        
        for(String s: nums){
            sb.append(s);
        }
        
        return sb.toString();
    }
}