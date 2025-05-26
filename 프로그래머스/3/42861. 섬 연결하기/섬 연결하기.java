import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        //자기 자신을 루트노드로 초기화
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        //비용순으로 정렬
        Arrays.sort(costs, (a,b)->a[2]-b[2]);
        
        int totalCost=0;
        int cnt=0;
        
        for(int[] edge: costs){
            int a=edge[0];
            int b=edge[1];
            int cost=edge[2];
            
            //서로 연결되지 않았다면 연결
            if(find(a)!=find(b)){
                union(a,b);
                totalCost+=cost;
                cnt++;
                if(cnt==n-1) break; //모든 간선 연결했으면 종료
            }
        }
        
        return totalCost;
    }
    static int find(int x){
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]); //이부분 
    }
    
    static void union(int a, int b){
        int roota=parent[a];
        int rootb=parent[b];
        if(roota<rootb) parent[rootb]=roota;
        else parent[roota]=rootb;
    }
}