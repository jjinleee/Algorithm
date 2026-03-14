import java.util.*;

class Solution {
    List<String> path=new ArrayList<>();
    List<String> answer=new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        path.add("ICN");
        visited=new boolean[tickets.length];
        
        Arrays.sort(tickets, (a,b)-> a[1].compareTo(b[1]));
        dfs(tickets, 0, "ICN");
        
        return answer.toArray(new String[0]);
    }
    void dfs(String[][] tickets, int cnt, String cur){
        if(cnt==tickets.length){
            answer=new ArrayList<>(path);
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i]=true;
                path.add(tickets[i][1]);
                
                dfs(tickets, cnt+1, tickets[i][1]);
                
                if(!answer.isEmpty()) return;
                
                visited[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}