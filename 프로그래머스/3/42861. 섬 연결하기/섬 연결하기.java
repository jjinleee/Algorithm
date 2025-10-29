import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        
        Arrays.sort(costs, (a,b)-> Integer.compare(a[2],b[2]));
        
        int totalCost=0;
        int cnt=0;
        
        for(int[] edge: costs){
            int a=edge[0];
            int b=edge[1];
            int cost=edge[2];
            
            if(find(a)!=find(b)){
                union(a,b);
                totalCost+=cost;
                cnt++;
                if(cnt==n-1) break;
            }
        }
        return totalCost;
    }
    //모든섬이 통행가능한지 확인
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    
    static void union(int a, int b){
        int roota=find(a);
        int rootb=find(b);
        if(roota<rootb) parent[rootb]=roota;
        else parent[roota]=rootb;
    }
}