import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> result=new HashSet<>();
        boolean[] visited=new boolean[numbers.length()];
        dfs("", numbers, visited, result);
        
        int count=0;
        for(int r : result){
            System.out.println(r);
            if(isPrime(r)) count++;
        }
        
        return count;
    }
    static void dfs(String current, String numbers, boolean[] visited, Set<Integer> result){
        if(!current.equals("")){
            result.add(Integer.parseInt(current));
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(current+numbers.charAt(i), numbers, visited, result);
                visited[i]=false;
            } 
        }
    }
    static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3 || n==5) return true;
        if(n%2==0 || n%3==0 || n%5==0) return false;
        
        for(int i=5;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}