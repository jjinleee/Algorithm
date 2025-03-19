import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<t;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            long answer=combination(m, n);
           
            sb.append(answer).append('\n');
        }

        System.out.println(sb);

    }

    public static long combination(int m,int n){
        if(n==0 || n==m) return 1;

        long result=1;
        for(int i=0;i<n;i++){
            result*=(m-i);
            result/=(i+1);
        }
        return result;
    }
}