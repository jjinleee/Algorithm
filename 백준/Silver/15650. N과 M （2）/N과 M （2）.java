import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[m];
        backtrack(1,0);

        System.out.println(sb);
    }
    static void backtrack(int start, int dept){
        if(dept==m){
            for(int s:arr){
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=n;i++){
            arr[dept]=i;
            backtrack(i+1, dept+1);
        }
    }
}