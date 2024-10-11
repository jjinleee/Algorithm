import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected;
    static boolean[] used;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        selected=new int[M];
        used= new boolean[N+1];

        backtrack(0);
        System.out.println(sb);
    }

    static void backtrack(int dept){
        if(dept==M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=1;i<=N;i++){
            if(!used[i]){
                used[i]=true;
                selected[dept]=i;
                backtrack(dept+1);
                used[i]=false;
            }
        }
    }
}