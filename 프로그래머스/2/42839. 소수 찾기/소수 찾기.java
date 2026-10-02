import java.util.*;

class Solution {
    Set<Integer> set=new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int n=numbers.length();
        boolean[] visited=new boolean[n];
        
        dfs(visited,"",numbers);
        
        for(int s : set){
            if(isPrime(s)) answer++;
        }
        
        return answer;
    }
    void dfs(boolean[] visited, String cur,String numbers){
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                
                String next=cur+numbers.charAt(i);
                set.add(Integer.parseInt(next));
                dfs(visited, next,numbers);
                visited[i]=false;
            }
        }
    }
    boolean isPrime(int n){
        if(n<2) return false;
        if(n==2 || n==3 || n==5) return true;
        
        if(n%2==0 || n%3==0 || n%5==0) return false;

        for(int i=7;i*i<=n;i++){
            if(n%i==0) return false;
        }
        
        return true;
    }
}