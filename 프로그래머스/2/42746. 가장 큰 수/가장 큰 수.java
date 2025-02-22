import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str=Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));
        
        if(str[0].equals("0")) return "0";
        
        return String.join("",str);
    }
}