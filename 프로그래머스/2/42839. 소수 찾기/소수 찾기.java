import java.util.*;

class Solution {
    Set<Integer> set= new HashSet<>();
    
    public int solution(String numbers) {
        int answer=0;
        boolean[] visited=new boolean[numbers.length()];
        dfs("",numbers,visited);
        
        for(int num:set){
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    
    //dfs
    void dfs(String current, String numbers, boolean[] visited){
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(current+numbers.charAt(i), numbers, visited);
                visited[i]=false;
            }
        }
        
    }
    
    static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        
        for(int i=5;i*i<=n;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}