import java.util.*;

class Solution {
    static boolean[] used;
    static List<String> result;
    public String[] solution(String[][] tickets) {
        int n=tickets.length;
        used= new boolean[n];
        result= new ArrayList<>();
        
        //티켓 사전순 정렬
        Arrays.sort(tickets, ((a,b)-> a[0].equals(b[0])? a[1].compareTo(b[1]) : a[0].compareTo(b[0])));
        List<String> path=new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", path, tickets);
        
        
        return result.toArray(new String[0]);
    }
    
    static boolean dfs(String curr,List<String> path, String[][] tickets ){
        if(path.size()==tickets.length+1){
            result=new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(curr)) {
                used[i] = true;
                path.add(tickets[i][1]);
                
                //백트래킹
                if(dfs(tickets[i][1], path, tickets)){
                    return true;
                }
                used[i] = false; 
                path.remove(path.size()-1);
            }
    }
        return false;
        
    }
}