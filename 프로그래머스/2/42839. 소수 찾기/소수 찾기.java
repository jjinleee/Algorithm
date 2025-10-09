import java.util.*;

class Solution {
    static Set<Integer> list= new HashSet<>();
    public int solution(String numbers) {
        
        
        boolean[] visited=new boolean[numbers.length()];
        
        dfs(visited, numbers, "");
        int cnt=0; 
        
        for(int l : list){
            if(isPrime(l)) cnt++;
        }
        return cnt;
    }
    static void dfs(boolean[] visited,String numbers, String num){
        if(!num.isEmpty()){
            list.add(Integer.parseInt(num));
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(visited, numbers, num+numbers.charAt(i));
                visited[i]=false;
            }
        }
        
    }
    static boolean isPrime(int n){
        if(n==0 || n==1) return false;
        if(n==2 || n==3 || n==5)  return true;
        if(n%2==0 || n%3==0 || n%5==0) return false;
        for(int i=7;i<n;i++){
            if(n%i==0) return false;
        }
        
        return true;
    }
}