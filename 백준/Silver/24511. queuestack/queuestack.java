import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        int[] a=new int[n];
        int[] b=new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        
        int m=Integer.parseInt(br.readLine());
        int[] c=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            c[i]=Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(a[i]==0) dq.add(b[i]);
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<m;i++){
            dq.addFirst(c[i]);
            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb.toString());
    }
}