import java.util.*;

class Solution {
    static List<String> list=new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited=new boolean[tickets.length];
        list.add("ICN");
        
        //티켓정렬
        Arrays.sort(tickets, (a,b)->a[0].equals(b[0]) ?  a[1].compareTo(b[1]):  a[0].compareTo(b[0]));
        
        dfs(tickets, "ICN", list);
        return list.toArray(new String[0]);
    }
    static boolean dfs(String[][] tickets,String current, List<String> path){
        //도달했을시
        if(list.size()==tickets.length+1){
            list=new ArrayList<>(path);
            return true;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i]=true;
                path.add(tickets[i][1]);
                if(dfs(tickets, tickets[i][1], path)) return true;
                //백트래킹
                visited[i]=false;
                path.remove(path.size()-1);
            }
        }
        return false;
        
        
    }
}