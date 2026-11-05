import java.util.*;

class Solution {
    Set<Integer> set= new HashSet<>();
    public int solution(String numbers) {
        int n=numbers.length();
        boolean[] visited=new boolean[n];
        
        dfs(numbers, visited, "");
        
        return set.size();
    }
    void dfs(String numbers, boolean[] visited, String cur){
        if(!cur.isEmpty()){
            if(isPrime(cur)) set.add(Integer.parseInt(cur));
        }
        

        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(numbers,  visited, cur+numbers.charAt(i));
                visited[i]=false;
                
            }
        }
    }
    boolean isPrime(String n){
        int num=Integer.parseInt(n);
        if(num<2) return false;
        if(num==2 || num==3 || num==5 || num==7) return true;
        
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        
        return true;
    }
}