import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        selected=new int[M];

        backtrack(1, 0);
        System.out.println(sb);
    }

    static void backtrack(int start, int dept){
        if(dept==M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=start;i<=N;i++){
            selected[dept]=i;
            backtrack(i, dept+1);
        }
    }
}