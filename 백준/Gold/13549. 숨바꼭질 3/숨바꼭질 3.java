import java.io.*;
import java.util.*;

public class Main {
    static int[] time=new int[100001];
    static int n,k;
    static boolean[] visited=new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        
        bfs(n);
    }


    

    public static void bfs(int start){
    Deque<Integer> q = new ArrayDeque<>();
    Arrays.fill(time, Integer.MAX_VALUE);  // 시간 초기화
    time[start] = 0;
    q.offer(start);

    while(!q.isEmpty()){
        int cur = q.poll();

        if(cur == k){
            System.out.println(time[k]);
            return;
        }

        // 순간이동 (0초)
        if(cur * 2 <= 100000 && time[cur * 2] > time[cur]){
            time[cur * 2] = time[cur];
            q.offerFirst(cur * 2);
        }

        // 걷기 (+1초)
        for(int next : new int[]{cur - 1, cur + 1}){
            if(next >= 0 && next <= 100000 && time[next] > time[cur] + 1){
                time[next] = time[cur] + 1;
                q.offerLast(next);
            }
        }
    }
}
}