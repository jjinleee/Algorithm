import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        char[][] orders={
            {'+','-','*'},
            {'+','*','-'},
            {'-','+','*'},
            {'-','*','+'},
            {'*','-','+'},
            {'*','+','-'}
        };
        
        List<Long> nums=new ArrayList<>();
        List<Character> ops=new ArrayList<>();
        
        StringBuilder sb= new StringBuilder();
        
        //숫자, 연산자 분리
        for(int i=0;i<expression.length();i++){
            char c= expression.charAt(i);
            
            if(c=='-'||c=='+'||c=='*'){
                nums.add(Long.parseLong(sb.toString()));                       sb.setLength(0);
                ops.add(c);
            } else sb.append(c);
        }
        
        nums.add(Long.parseLong(sb.toString()));
        
        //모든 우선순위대로 계산
        for(char[] order : orders){
            List<Long> tmpNums=new ArrayList<>(nums);
            List<Character> tmpOps=new ArrayList<>(ops);
            
            for(char op : order){
                for(int i=0;i<tmpOps.size();i++){
                    if(tmpOps.get(i)==op){
                        long a=tmpNums.get(i);
                        long b=tmpNums.get(i+1);
                        long result=calculate(a,b,op);
                        
                        tmpNums.remove(i);
                        tmpNums.remove(i);
                        tmpNums.add(i,result);
                        
                        tmpOps.remove(i);
                        i--;
                        
                    }
                }
            }
            answer=Math.max(answer, Math.abs(tmpNums.get(0)));
        }
        
        
        return answer;
    }
    long calculate(long a, long b, char op){
        if(op=='-') return a-b;
        else if(op=='+') return a+b;
        else return a*b;
    }
}